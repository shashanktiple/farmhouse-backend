package org.app.farmhouse.repository;

import org.app.farmhouse.dto.inventory.ProductDto;
import org.app.farmhouse.modal.inventory.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteProductById(Long productId);
    Optional<Product> findById(Long productId);

    List<Product> findAllBySearchContainsIgnoreCase(String searchKey);
}
