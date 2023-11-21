package org.app.farmhouse.dto.order;

import lombok.Data;
import org.app.farmhouse.modal.order.SavedLater;

@Data
public class SavedLaterDto {

    private String itemId;
    private Long qty;

    public SavedLaterDto(SavedLater obj) {
        this.itemId = obj.getItemId();
        this.qty = obj.getQty();
    }
}
