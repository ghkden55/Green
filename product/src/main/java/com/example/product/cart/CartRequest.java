package com.example.product.cart;

import com.example.product.option.Option;
import com.example.product.user.User;
import lombok.Getter;
import lombok.Setter;

public class CartRequest {

    @Getter
    @Setter
    public class SaveDTO {

        private Long optionId;

        private Long quantity;

        public Cart toEntity(Option option, User user) {
            return Cart.builder()
                    .user(user)
                    .option(option)
                    .quantity(quantity)
                    .price(option.getPrice() * quantity)
                    .build();
        }

    }


    @Getter
    @Setter
    public static class UpdateDTO {

        private Long cartId;

        private Long quantity;

        public UpdateDTO(Long cartId, Long quantity) {
            this.cartId = cartId;
            this.quantity = quantity;
        }
    }

}
