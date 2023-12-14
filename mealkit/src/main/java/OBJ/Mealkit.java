package OBJ;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Mealkit {

    Long MealID;
    String MealName, MealCategory, MealInfo;
    int MealPrice;

    public Mealkit() {}

    @Builder
    public Mealkit(Long MealID, String MealName, String MealCategory, int MealPrice, String MealInfo) {
        this.MealID = MealID;
        this.MealName = MealName;
        this.MealCategory = MealCategory;
        this.MealInfo = MealInfo;
        this.MealPrice = MealPrice;
    }
}
