package pl.io_proj.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.io_proj.model.Product;
import pl.io_proj.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public String test(HttpServletRequest request) {
        return request.toString();
    }

    public Product getProductByName(String name) throws Exception {

        if (name == null || name.isEmpty())
            throw new Exception("Product name is empty");

        return repository.findByName(name)
                .orElseThrow(() -> new Exception("Product not found"));
    }
}

