package org.app.farmhouse.modal.order;

import jakarta.persistence.*;
import lombok.Data;
import org.app.farmhouse.modal.inventory.Product;

@Entity(name = "orderinfo")
@Data
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private Long quantity;
    private Double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}
