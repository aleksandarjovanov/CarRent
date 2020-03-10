package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Renter {

    private Long id;
    private String name;
    private int age;
    private Sex sex;

}
