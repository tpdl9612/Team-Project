package com.korea.productPage.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductApiClient productApiClient;

    @GetMapping("/product/list")
    public String productList(@RequestParam ("keyword")String keyword, Model model) {
        if(keyword == null || keyword.isEmpty()) {
            return "redirect:/";  // 검색어가 없을 경우 메인페이지로 이동
        }
        ProductResponseDto responseDto = productApiClient.requestProduct(keyword);

        List<ProductDto> products = responseDto.getItems();
        model.addAttribute("products", products);

        return "list";

    }

    @GetMapping("/")
    public String root(){
        return "main";
    }
}
