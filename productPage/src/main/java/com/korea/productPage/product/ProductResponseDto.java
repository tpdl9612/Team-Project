package com.korea.productPage.product;


import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    List<ProductDto> items;
}
