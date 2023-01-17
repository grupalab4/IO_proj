package pl.io_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.io_proj.model.DBUser;
import pl.io_proj.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductByName(String name);
    boolean existsProductByName(String name);

    Optional<Product> findByName(String name);
}
