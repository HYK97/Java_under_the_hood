package customfunctioninterface.example;

import lombok.*;

import java.math.BigDecimal;




@ToString(callSuper = true)
public class Movie extends Product{

    private String author;
    private String movieName;

    public String getAuthor() {
        return author;
    }

    public String getMovieName() {
        return movieName;
    }



    public Movie(Long id, BigDecimal price, String author, String movieName) {
        super(id, price);
        this.author = author;
        this.movieName = movieName;
    }


}
