package org.app.farmhouse.modal.order;

import jakarta.persistence.*;
import lombok.Data;
import org.app.farmhouse.constants.OrderStatus;
import org.app.farmhouse.modal.user.Address;
import org.app.farmhouse.modal.user.User;

import java.util.Date;
import java.util.List;

@Entity(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToMany(mappedBy = "order")
    private List<OrderInfo> infoProduct;
    private String paymentMode;

    private Date orderDate;
    private OrderStatus status;

}
