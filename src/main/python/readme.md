-----------------------------------------
skrócony tutorial korzystania ze skryptu:
-----------------------------------------
1. ustaw w pliku confFile odpowiednie password i database
2. zainstaluj 
    pip install psycopg2
    pip install sheet2dict
3. uruchom skrypt, powinna się pojawić wiadomość finished

-----------------------------------------------
szczegółowy tutorial korzystania z tego skryptu
-----------------------------------------------
1.ustaw odpowiednie wartości w pliku confFile.cfg
    -host: raczej dla kazdego bedzie localhost
    -database: to nazwa bazy danych, domyslna baza danych nazywa sie postgres, natomiast nie wiem jak nazywa sie baza z naszego repo
    -user: tak samo, domyślny jest postgres
    -password: to chyba każdy ustawia sam
    -path: to jest ścieżka do pliku z danymi, który powinien ci się pobrać klonując repo, nie zmieniaj, chyba, że chcesz podać inne dane

    nie zmieniaj nic poza wartościami w bracketach {}

2.pobierz dwie biblioteki sheet2dict oraz psycopg2
    aby to zrobić, uruchom cmd i wpisz komendy
    
    pip install psycopg2
    pip install sheet2dict
    
    jeżeli pokazuje ci sie wiadomość 
    'pip' is not recognized as an internal or external command,
    operable program or batch file.
    to znaczy, że albo nie masz zainstalowanego pythona, albo nie masz
    dodanego go do zmiennych środowiskowych
    tutorial dodawania do zmiennych środowiskowych: https://realpython.com/add-python-to-path/

    wymagana wersja pythona, to python 3.9, skrypt powinien działać na każdym pythonie 3, natomiast na 2 prawdopodobnie nie 

3. uruchom skrypt w dowolnym IDE, lub:
    w cmd zmień folder na ten, w którym masz znajduje się skrypt, 
    np w moim przypadku 
    cd "C:\Users\Szymon\Desktop\Inżynieria oprogramowania\IO_proj\src\main\python"
    
    (sciezke musisz okreslic sam)

    wywołaj komendę:
    python main.py

4. na ekranie powinna sie wyswietlic wiadomosc 
    finished
    a tabelka products w bazie danych powinna zostać zapełniona produktami


Jak cokolwiek nie będzie działało, to od razu pisz do mnie (Szymon Rozmus).
Wszystkie problemy, które się pojawiły będę chciał uwzględnić w tym readme (narazie to jest bardzo ogólna wersja).