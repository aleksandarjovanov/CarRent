package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    private String embg;
    private  String name;
    private int age;
    private Sex sex;
    private String driverLicenceNumber;
    private boolean crimeRecord;

    private List<Renter> following;

    public void follow(Renter renter) {
        this.following.add(renter);
        renter.getFollowers().add(this);
    }

    public void unFollow(Renter renter) {
        this.following.remove(renter);
        renter.getFollowers().remove(this);
    }

}
