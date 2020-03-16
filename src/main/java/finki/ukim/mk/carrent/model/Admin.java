package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

    private Long id;
    private String name;

    public void createAdmin(String name){
        this.name = name;
    }
}
