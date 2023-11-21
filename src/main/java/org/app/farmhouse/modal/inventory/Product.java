package org.app.farmhouse.modal.inventory;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.dto.inventory.ProductDto;
import org.app.farmhouse.dto.inventory.ProductMediaDto;

import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductMedia> productMedia;

    public Product(ProductDto dto) {
        this.id = dto.getId();
        this.category = dto.getCategory();
        this.name = dto.getName();
        this.info = dto.getInfo();
        this.available = dto.isAvailable();
        this.quantity = dto.getQuantity();
        this.unit = dto.getUnit();
        this.unitPrice = dto.getUnitPrice();
        this.discount = dto.getDiscount();
        this.search = dto.getSearch();
        //this.productMedia= dto.getProductMedia().stream().map(ProductMedia::new).collect(Collectors.toList());
    }
}
