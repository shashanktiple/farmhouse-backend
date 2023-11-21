package org.app.farmhouse.dto.inventory;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.modal.inventory.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String category;
    private String name;
    private String info;
    private boolean available;
    private Long quantity;
    private Long unit;
    private Double unitPrice;
    private int discount;
    private String search;
    private List<ProductMediaDto> productMedia;


    public ProductDto(Product product) {
        this.id = product.getId();
        this.category = product.getCategory();
        this.name = product.getName();
        this.info = product.getInfo();
        this.available = product.isAvailable();
        this.quantity = product.getQuantity();
        this.unit = product.getUnit();
        this.unitPrice = product.getUnitPrice();
        this.discount = product.getDiscount();
        this.search = product.getSearch();
        this.productMedia = product.getProductMedia() == null ? null : product.getProductMedia().stream().map(ProductMediaDto::new).collect(Collectors.toList());
    }
}
