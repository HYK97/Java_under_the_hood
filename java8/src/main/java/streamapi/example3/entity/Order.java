package streamapi.example3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderedItem> items;

    public BigDecimal totalPrice() {
        return items.stream()
                .map(item->item.getTotalPrice())
                .reduce(BigDecimal.ZERO,(price1,price2) -> price1.add(price2));

    }
}
