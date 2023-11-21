package org.app.farmhouse.dto.inventory;

import lombok.Data;
import org.app.farmhouse.modal.inventory.ProductReview;

import java.util.Date;

@Data
public class ProductReviewDto {
    private String userId;
    private Date reviewDate;
    private String review;

    public ProductReviewDto(ProductReview review) {
        this.userId = review.getUser().getUsername();
        this.reviewDate = review.getReviewDate();
        this.review = review.getReview();
    }
}
