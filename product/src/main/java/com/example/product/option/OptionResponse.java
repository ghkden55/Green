package com.example.product.option;

import com.example.product.product.Product;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OptionResponse {

    private Long id;

    private Long productId;

    private Product product;

    // 옵션 상품 이름, 필수 입력값
    private String optionName;

    // 옵션 상품 가격
    private Long price;

    // 옵션 상품 수량
    private Long quantity;


    public static class FindByProductIdDTO {

        private Long id;

        private Long productId;

        // 옵션 상품 이름, 필수 입력값
        private String optionName;

        // 옵션 상품 가격
        private Long price;

        // 옵션 상품 수량
        private Long quantity;

        public FindByProductIdDTO(Option option) {
            this.id = option.getId();
            this.productId = option.getProduct().getId();
            this.optionName = option.getOptionName();
            this.price = option.getPrice();
            this.quantity = option.getQuantity();
        }
    }


    public static class FindAllDTO {

        private Long id;

        private Long productId;

        // 옵션 상품 이름, 필수 입력값
        private String optionName;

        // 옵션 상품 가격
        private Long price;

        // 옵션 상품 수량
        private Long quantity;

        public FindAllDTO(Option option) {
            this.id = option.getId();
            this.productId = option.getProduct().getId();
            this.optionName = option.getOptionName();
            this.price = option.getPrice();
            this.quantity = option.getQuantity();
        }
    }

}
