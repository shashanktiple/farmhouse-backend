package org.app.farmhouse.modal.inventory;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.dto.inventory.ProductMediaDto;

@Entity(name = "productmedia")
@Data
@NoArgsConstructor
public class ProductMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private String mediaFile;

    public ProductMedia(ProductMediaDto dtoMedia){
        this.mediaFile = dtoMedia.getMediaFile();
    }
}
