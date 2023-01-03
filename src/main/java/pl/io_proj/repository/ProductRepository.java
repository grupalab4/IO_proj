package pl.io_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.io_proj.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
