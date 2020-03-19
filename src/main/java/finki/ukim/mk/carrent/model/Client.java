package finki.ukim.mk.carrent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String embg;

    @Column(name = "client_name")
    private  String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String driverLicenceNumber;
    private boolean crimeRecord;

    @JsonIgnore
    @ManyToMany(mappedBy = "followers")
    private List<Renter> following;

    public void follow(Renter renter) {
        this.following.add(renter);
        renter.getFollowers().add(this);
    }

    public void unFollow(Renter renter) {
        this.following.remove(renter);
        renter.getFollowers().remove(this);
    }

    public void createClient(String embg, String name, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord){
        this.embg = embg;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.driverLicenceNumber = driverLicenceNumber;
        this.crimeRecord = crimeRecord;
        this.following = new ArrayList<>();
    }

}
