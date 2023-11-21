package org.app.farmhouse.modal.order;

import jakarta.persistence.*;
import lombok.Data;
import org.app.farmhouse.modal.user.User;

@Entity(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private User user;

    private String itemId;
    private Long Qty;
}
