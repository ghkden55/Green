package com.example.product.product;

import com.example.product.option.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

//@NoArgsConstructor
public class ProductResponse {


    @Getter
    @Setter
    @NoArgsConstructor
    public static class FindAllDTO {
        private Long id;

        private String productName;

        private String description;

        private String image;

        private int price;

        //private int quantity; // 수량은 옵션에 들어갈 것 이므로 나중에 삭제 가능성

        public FindAllDTO(Product product) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.description = product.getDescription();
            this.image = product.getImage();
            this.price = product.getPrice();
        }

    }


    @Getter
    @Setter
    public static class FindByIdDTO{
        private Long id;

        private String productName;

        private String description;

        private String image;

        private int price;

        private List<OptionDTO> optionList;

        //private int quantity; // 수량은 옵션에 들어갈 것 이므로 나중에 삭제 가능성

        public FindByIdDTO(Product product, List<Option> optionList) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.description = product.getDescription();
            this.image = product.getImage();
            this.price = product.getPrice();
            this.optionList = optionList.stream().map(OptionDTO::new)
                    .collect(Collectors.toList());
        }

    }


    @Getter
    @Setter
    public static class OptionDTO {
        private Long id;
        private String optionName;
        private Long Price;
        private Long quantity;

        public OptionDTO(Option option) {
            this.id = option.getId();
            this.optionName = option.getOptionName();
            this.Price = option.getPrice();
            quantity = option.getQuantity();
        }

    }

}
