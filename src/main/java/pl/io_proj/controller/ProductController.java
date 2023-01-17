package pl.io_proj.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.io_proj.model.Product;
import pl.io_proj.service.ProductService;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        return service.test(request);
    }

    @GetMapping("/get-product-name")
    public ResponseEntity<?> getProductName(@RequestParam String productName) {

        try {
            Product product = service.getProductByName(productName);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }


    }
}
