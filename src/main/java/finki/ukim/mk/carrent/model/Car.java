package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_plate")
    private String plate;

    @Column(name = "car_mark")
    private String mark;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_color")
    private String color;

    private String imgLink;
    private int yearOfProduction;
    private int costPerDay;
    private double rating;
    private int numberOfRatings;
    private int sumOfRatings;  // needed for calculation

    @ManyToOne
    private Renter renter;

    public void calculateRating(int rating){
        this.numberOfRatings++;
        this.sumOfRatings+= rating;
        this.rating = (double)this.sumOfRatings / numberOfRatings;
    }

    public void createCar(String plate, String mark, String model, String color, int yearOfProduction, int cost, String imgLink, double rating, int numberOfRatings, int sumOfRatings, Renter renter){
        this.plate = plate;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
        this.costPerDay = cost;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
        this.imgLink = imgLink;
        this.renter = renter;
        this.sumOfRatings = sumOfRatings;
    }

}
