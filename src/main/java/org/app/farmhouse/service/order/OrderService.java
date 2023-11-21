package org.app.farmhouse.service.order;

import org.app.farmhouse.dto.order.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    /**
     * Load order details for given order id
     * @param orderID
     * @return
     */
    OrderDto loadOrderByOrderId(String orderID);

    /**
     * Load all orders for a given user id
     * @param username
     * @return
     */
    List<OrderDto> loadOrdersByUsername(String username);
}
