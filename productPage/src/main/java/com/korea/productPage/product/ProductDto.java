package com.korea.productPage.product;


import lombok.Builder;
import lombok.Data;

@Data
public class ProductDto {
    private String title;
    private String link;
    private String image;
    private String lprice;
    private String brand;
    private String productId;
    private String category1;
    private String category2;

    @Builder
    public ProductDto (){
        this.title = title;
        this.link = link;
        this.image = image;
        this.lprice = lprice;
        this.brand = brand;
        this.productId = productId;
        this.category1 = category1;
        this.category2 = category2;
    }

}
