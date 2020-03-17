package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    private Long id;
    private String plate;
    private String mark;
    private String model;
    private String color;
    private int yearOfProduction;
    private int costPerDay;
    private double rating = 0;
    private int numberOfRatings = 0;

    private Renter renter;
    private List<Termin> terminList;

    public void calculateRating(int rating){
        this.numberOfRatings++;
        this.rating = (this.rating + rating) / numberOfRatings;
    }

    public void createCar(String mark, String model, String color, int yearOfProduction, int cost, Renter renter){
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
        this.costPerDay = cost;
        this.rating = 0;
        this.numberOfRatings = 0;
        this.renter = renter;
        this.terminList = new ArrayList<>();
    }
}
