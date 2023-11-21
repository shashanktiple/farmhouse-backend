package org.app.farmhouse.service.inventory;

import org.app.farmhouse.dto.inventory.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    /**
     * Load all the products from repository
     */
    List<ProductDto> loadAllProducts();


    /**
     * Add new product into inventory
     * @param dto
     */
    ProductDto addProductToInventory(ProductDto dto);

    /**
     * Deleting product from inventory using productId
     * @param productId
     */
    void deleteProductById(Long productId);

    /**
     * Updating details of existing product
     * @param dto
     */
    void updateProduct(ProductDto dto);


    /**
     * Searching desired product
     * @param searchKey
     */
    List<ProductDto> searchProduct(String searchKey);
}
