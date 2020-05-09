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
    private List<Client> followers;

    public void createRenter(Long id,String embg, String firstName, String lastName, int age, Sex sex, String imgUrl, List<Client> followersList){
        this.id = id;
        this.embg = embg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.imgUrl = imgUrl;
        this.followers = followersList;
    }
}
