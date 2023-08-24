package customfunctioninterface.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class Order implements Calculate{
    private Long id;
    private Product product;
    private int count;

    @Override
    public BigDecimal getPrice(){
        BigDecimal price = BigDecimal.ZERO;
        price = price.add(product.getPrice().multiply(BigDecimal.valueOf(count)));
        return price;
    }

}
