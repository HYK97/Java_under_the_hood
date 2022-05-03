package customfunctioninterface.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class Movie extends Product{

    private String author;
    private String movieName;


    public Movie(Long id, BigDecimal price, String author, String movieName) {
        super(id, price);
        this.author = author;
        this.movieName = movieName;
    }


}
