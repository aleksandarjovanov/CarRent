package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    private String embg;
    private  String name;
    private String driverLicenceNumber;
    private int age;
    private Sex sex;
    private boolean crimeRecord;

}
