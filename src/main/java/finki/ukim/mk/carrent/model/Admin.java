package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String imgUrl;

    public void createAdmin(Long id, String firstName, String lastName, String imgUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imgUrl = imgUrl;
    }
}
