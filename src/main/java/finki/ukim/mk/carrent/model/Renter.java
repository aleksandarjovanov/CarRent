package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Renter {

    private Long id;
    private String embg;
    private String name;
    private int age;
    private Sex sex;

    private List<Client> followers;

    public void createRenter(String embg, String name, int age, Sex sex){
        this.embg = embg;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.followers = new ArrayList<>();
    }
}
