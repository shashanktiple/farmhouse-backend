package org.app.farmhouse.modal.inventory;

import jakarta.persistence.*;
import lombok.Data;
import org.app.farmhouse.modal.user.User;

import java.util.Date;

@Entity(name = "productreview")
@Data
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private User user;
    private Date reviewDate;
    private String review;
}
