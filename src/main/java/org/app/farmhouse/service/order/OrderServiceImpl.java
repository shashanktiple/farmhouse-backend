package org.app.farmhouse.service.order;

import org.app.farmhouse.dto.order.OrderDto;
import org.app.farmhouse.modal.order.Order;
import org.app.farmhouse.repository.OrderRepository;
import org.app.farmhouse.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Load order details for given order id
     *
     * @param orderID
     * @return
     */
    @Override
    public OrderDto loadOrderByOrderId(String orderID) {
        if(logger.isTraceEnabled())
            logger.trace(String.format("Loading order by order ID : %s", orderID));

        Order order = orderRepository.findById(orderID).orElseThrow();
        return new OrderDto(order);
    }

    /**
     * Load all orders for a given user id
     *
     * @param username
     * @return
     */
    @Override
    public List<OrderDto> loadOrdersByUsername(String username) {
        if(logger.isTraceEnabled())
            logger.trace(String.format("Loading all orders by username : %s", username));

        List<Order> list = orderRepository.findByUser(userRepository.findUserByUsername(username).orElseThrow()).orElseThrow();
        return list.stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
