package finki.ukim.mk.carrent.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @Column(name = "from_time")
    private LocalDate from;

    @Column(name = "to_time")
    private LocalDate to;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Client client;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Car car;

    public void createReservation(Client client, Car car, String comment, LocalDate from, LocalDate to){
        this.client = client;
        this.car = car;
        this.comment = comment;
        this.from = from;
        this.to = to;
    }

}
