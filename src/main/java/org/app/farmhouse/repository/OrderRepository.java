package org.app.farmhouse.repository;

import org.app.farmhouse.modal.order.Order;
import org.app.farmhouse.modal.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    /**
     * Load order by order id
     * @param id
     * @return
     */
    Optional<Order> findById(String id);

    /**
     * Load all order for a given user
     * @param user
     * @return
     */
    Optional<List<Order>> findByUser(User user);
}
