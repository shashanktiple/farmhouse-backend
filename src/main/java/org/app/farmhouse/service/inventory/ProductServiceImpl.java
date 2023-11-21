package org.app.farmhouse.service.inventory;

import org.app.farmhouse.dto.inventory.ProductDto;
import org.app.farmhouse.modal.inventory.Product;
import org.app.farmhouse.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    /**
     * Load all the products from repository
     */
    @Override
    public List<ProductDto> loadAllProducts() {
        if(logger.isTraceEnabled()){
            logger.trace("Loading all products from Database.");
        }

        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    /**
     * Add new product into inventory
     * @param dto
     */
    @Override
    public ProductDto addProductToInventory(ProductDto dto){
        Product product = new Product(dto);
        productRepository.save(product);
        return new ProductDto(product);
    }

    /**
     * Deleting product from inventory using productId
     * @param productId
     */
    @Override
    public void deleteProductById(Long productId){
        productRepository.deleteProductById(productId);
    }

    /**
     * Updating details of existing product
     * @param dto
     */
    @Override
    public void updateProduct(ProductDto dto){
        Product product = new Product(dto);
        productRepository.save(product);
    }

    public List<ProductDto> searchProduct(String searchKey){
       return productRepository.findAllBySearchContainsIgnoreCase(searchKey)
               .stream().map(ProductDto::new).collect(Collectors.toList());
//     return productRepository.findAllBySearchContainingIgnoreCase(dto).stream().map((d)->{new ProductDto(d)}).collect(Collectors.toList());
    }



}
