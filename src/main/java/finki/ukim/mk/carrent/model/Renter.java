package finki.ukim.mk.carrent.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Renter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String embg;

    @Column(name = "renter_name")
    private String firstName;
    private String lastName;
    private int age;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String imgUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Client> followers;

    public void createRenter(String embg, String firstName, String lastName, int age, Sex sex, String imgUrl, List<Client> followersList){
        this.embg = embg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.imgUrl = imgUrl;
        this.followers = followersList;
    }
}
