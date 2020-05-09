package finki.ukim.mk.carrent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    @Id
    private Long id;
    private String embg;

    @Column(name = "client_name")
    private String firstName;
    private String lastName;
    private int age;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String driverLicenceNumber;
    private boolean crimeRecord;
    private String imgUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "followers")
    private List<Renter> following;

    public void follow(Renter renter) {
        if(!this.following.contains(renter)) {
            this.following.add(renter);
            renter.getFollowers().add(this);
        }
    }

    public void unFollow(Renter renter) {
        if(this.following.contains(renter)) {
            this.following.remove(renter);
            renter.getFollowers().remove(this);
        }
    }

    public void createClient(Long id, String embg, String firstName, String lastName, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord, String imgUrl){
        this.id = id;
        this.embg = embg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.driverLicenceNumber = driverLicenceNumber;
        this.crimeRecord = crimeRecord;
        this.imgUrl = imgUrl;
        this.following = new ArrayList<>();
    }

    @PreRemove
    private void removeClientsFromRenters() {
        for (Renter r : following) {
            r.getFollowers().remove(this);
        }
    }

}
