package DTO;

import OBJ.Mealkit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealkitDTO {

    public MealkitDTO() {}

    public MealkitDTO(Mealkit mealkit) {
        MealID = mealkit.getMealID();
        MealName = mealkit.getMealName();
        MealCategory = mealkit.getMealCategory();
        MealPrice = mealkit.getMealPrice();
        MealInfo = mealkit.getMealInfo();
    }

    private Long MealID;
    private String MealName, MealCategory, MealInfo;
    private int MealPrice;

}
