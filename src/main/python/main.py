import psycopg2
from sheet2dict import Worksheet
import traceback
import math


confFile = open("confFile.cfg", "r")

host = confFile.readline().removesuffix("}\n").removeprefix("host: {")
database = confFile.readline().removesuffix("}\n").removeprefix("database: {")
user  = confFile.readline().removesuffix("}\n").removeprefix("user: {")
password = confFile.readline().removesuffix("}\n").removeprefix("password: {")
path = confFile.readline().removesuffix("}\n").removeprefix("path: {")


connection = psycopg2.connect(host = host,
                              database = database,
                              user = user,
                              password = password)


cur = connection.cursor()
cur.execute("SET search_path TO liczymy_kalorie")

ws = Worksheet()
csv_file = open(path, "r")

ws.csv_to_dict(csv_file = csv_file, delimiter = "\t")

try:
    for item in ws.sheet_items:
        #code
        if len(item["code"]) > 0:
            #print(item["code"])
            code = int(item["code"])
        else:
            raise ValueError("product id should never be empty") #should never happen
            break

        #energy-kcal
        if len(item["energy-kcal_100g"]) > 0:
            #print(item["energy-kcal_100g"])
            energy_kcal = int(math.floor(float(item["energy-kcal_100g"])))
        else:
            energy_kcal = 0

        #ingredients_text
        if len(item["ingredients_text"]) > 0:
            #print(item["ingredients_text"])
            ingredients_text = item["ingredients_text"][:255] #truncate to 255
        else:
            ingredients_text = ""

        #generic_name
        if len(item["generic_name"]) > 0:
            #print(item["generic_name"])
            generic_name = item["generic_name"][:255]
        else:
            generic_name = ""

        #product_name
        if len(item["product_name"]) > 0:
            #print(item["product_name"])
            product_name = item["product_name"][:255]
        else:
            product_name = ""


        #print("\n")
        #print(code + " " + energy_kcal + " " + ingredients_text + " " + generic_name + " " + product_name + "\n")

        #push data to database
        #cur.execute("INSERT INTO test (num, data) VALUES (%s, %s)", (100, "abc'def"))
        try:
            cur.execute("INSERT INTO products (id_product, calorific_value_per100g, composition, description, name)  "
                    "VALUES (COALESCE(%s, NULL), COALESCE(%s, NULL), COALESCE(%s, NULL), COALESCE(%s, NULL), COALESCE(%s, NULL))",
                    (code, energy_kcal, ingredients_text, generic_name, product_name))
        except:
            print(traceback.format_exc())
            print(code, str(len(str(code))), " ", energy_kcal, str(len(str(energy_kcal))), " ", ingredients_text, str(len(ingredients_text)), " ", generic_name, str(len(generic_name)), " ", product_name, str(len(product_name)))
            break
except ValueError:
    print(traceback.format_exc())
    print("in data taken from " + path + " some product's code was empty, which is not allowed!")
    print("exiting program...")
    cur.close()
    connection.close()




try:
    connection.commit() #commiting all changes in single transaction!
except:
    print(traceback.format_exc())


cur.close()
connection.close()

print("finished")

