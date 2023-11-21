package org.app.farmhouse.dto.order;

import lombok.Data;
import org.app.farmhouse.dto.inventory.ProductDto;
import org.app.farmhouse.modal.order.OrderInfo;

@Data
public class OrderInfoDto {
    private ProductDto product;
    private Long quantity;
    private Double unitPrice;
    private Double totalPrice;

    public OrderInfoDto(OrderInfo orderInfo) {
        this.product = new ProductDto(orderInfo.getProduct());
        this.quantity = orderInfo.getQuantity();
        this.totalPrice = orderInfo.getTotalPrice();
    }
}
