package org.app.farmhouse.dto.order;

import lombok.Data;
import org.app.farmhouse.modal.order.Cart;

@Data
public class CartDto {
    private String itemId;
    private Long qty;

    public CartDto(Cart cart) {
        this.itemId = cart.getItemId();
        this.qty = cart.getQty();
    }
}
