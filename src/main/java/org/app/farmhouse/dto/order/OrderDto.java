package org.app.farmhouse.dto.order;

import lombok.Data;
import org.app.farmhouse.constants.OrderStatus;
import org.app.farmhouse.dto.user.AddressDto;
import org.app.farmhouse.modal.order.Order;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDto {

    private AddressDto address;
    private List<OrderInfoDto> infoProduct;
    private String paymentMode;
    private Date orderDate;
    private OrderStatus status;

    public OrderDto(Order order) {
        this.address = new AddressDto(order.getAddress());
        this.infoProduct = order.getInfoProduct().stream().map(OrderInfoDto::new).collect(Collectors.toList());
        this.paymentMode = order.getPaymentMode();
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
    }

    public OrderDto(){

    }
}
