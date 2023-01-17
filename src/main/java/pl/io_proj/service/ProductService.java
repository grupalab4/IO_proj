package pl.io_proj.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.io_proj.model.Product;
import pl.io_proj.repository.ProductRepository;
import pl.io_proj.responses.RegisterResponse;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    private Product addProduct(Product product) {
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

    public String addProduct(String name, String description, String composition, Integer calorificValuePer100G) {
        if (name == null || calorificValuePer100G == null)
            return "Nie podano name lub calorificValuePer100G";

        if (existsProductByName(name))
            return "Istnieje produkt o takiej samej nazwie";

        addProduct(new Product(name, description, composition, calorificValuePer100G));
        return "Produkt "+name+" dodano";
    }

    public Product getProductByName(String name) throws Exception {

        if (name == null || name.isEmpty())
            throw new Exception("Product name is empty");

        return repository.findByName(name)
                .orElseThrow(() -> new Exception("Product not found"));
    }
}

