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
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Client> followers;

    public void createRenter(String embg, String name, int age, Sex sex, List<Client> followersList){
        this.embg = embg;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.followers = followersList;
    }
}
