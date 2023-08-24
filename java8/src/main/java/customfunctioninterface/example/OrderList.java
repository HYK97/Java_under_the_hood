package customfunctioninterface.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class OrderList implements Calculate{
    private Long id;
    private List<Order> orderList =new ArrayList<>();


    @Override
    public BigDecimal getPrice() {
        Utils util = new Utils();
        List<BigDecimal> mapper = util.mapper(orderList, (i) -> i.getPrice());
        BigDecimal result =BigDecimal.ZERO;
        for (BigDecimal data : mapper) {
            result=result.add(data);
        }
        return result;
    }
}
