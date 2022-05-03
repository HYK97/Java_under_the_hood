package customfunctioninterface.example;

import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
@ToString(callSuper = true)
public class Food extends Product {
    private String foodName;

    public Food(Long id, BigDecimal price,String foodName) {
        super(id, price);
        this.foodName=foodName;
    }
}
