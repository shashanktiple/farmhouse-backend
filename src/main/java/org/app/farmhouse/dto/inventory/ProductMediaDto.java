package org.app.farmhouse.dto.inventory;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.modal.inventory.ProductMedia;

@Data
@NoArgsConstructor
public class ProductMediaDto {

    private String mediaFile;

    public ProductMediaDto(ProductMedia media) {
        this.mediaFile = media.getMediaFile();
    }
}
