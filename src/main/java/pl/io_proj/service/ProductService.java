package pl.io_proj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.io_proj.model.Product;
import pl.io_proj.repository.ProductRepository;
import pl.io_proj.responses.ProductResponse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public Product smallAddProduct(Product product) {
        Product newProduct = new Product(
                product.getName(),
                product.getDescription(),
                product.getComposition(),
                product.getCalorificValuePer100G()
        );

        return repository.save(newProduct);
    }
    private boolean existsProductByName(String name) {
        return repository.existsProductByName(name);
    }

    public String addProduct(String name, String description, String composition, Integer calorificValuePer100G) throws JsonProcessingException {
        if (name == null || calorificValuePer100G == null)
            return ProductResponse.NotEnoughParameters.json();

        if (existsProductByName(name))
            return ProductResponse.ProductAlreadyExists.json();

        smallAddProduct(new Product(name, description, composition, calorificValuePer100G));
        return ProductResponse.Ok.json();
    }

    public Product getProductByName(String name) throws Exception {

        if (name == null || name.isEmpty())
            throw new Exception("Product name is empty");

        return repository.findByName(name)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    public ArrayList<String> findAllProductsByName(String input) {
        ArrayList<String> result = new ArrayList<>();

        for(Product p : repository.findAll()) {
            if(Objects.requireNonNull(p.getName().contains(input))) result.add(p.getName());
            if(result.size()>=20) return result;
        }

        return result;
    }
}

