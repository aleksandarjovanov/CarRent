package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    private String plate;
    private String mark;
    private String model;
    private String color;
    private int yearOfProduction;
    private int costPerDay;
    private double rating = 0;
    private int numberOfRatings = 0;

    private Renter renter;

    public void calculateRating(int rating){
        this.numberOfRatings++;
        this.rating = (this.rating + rating) / numberOfRatings;
    }
}
