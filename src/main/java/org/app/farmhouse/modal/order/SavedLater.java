package org.app.farmhouse.modal.order;

import jakarta.persistence.*;
import lombok.Data;
import org.app.farmhouse.modal.user.User;

@Entity(name = "savedlater")
@Data
public class SavedLater {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private User user;

    private String itemId;
    private Long Qty;
}
