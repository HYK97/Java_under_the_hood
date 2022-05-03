package customfunctioninterface.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;




@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private BigDecimal price;


}
