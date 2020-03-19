package finki.ukim.mk.carrent.model;

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
    private List<Client> followers;

    public void createRenter(String embg, String name, int age, Sex sex){
        this.embg = embg;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.followers = new ArrayList<>();
    }
}
