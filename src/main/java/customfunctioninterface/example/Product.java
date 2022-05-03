package customfunctioninterface.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;



@ToString(callSuper = true)
@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private BigDecimal price;


}
