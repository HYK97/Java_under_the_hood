package customfunctioninterface.example;

import java.math.BigDecimal;


public class DiscountMovie extends Movie {

    public DiscountMovie(Long id, BigDecimal price, String author, String movieName) {
        super(id, price, author, movieName);
    }
}
