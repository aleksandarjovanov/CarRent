package finki.ukim.mk.carrent.model.LocalData;

import finki.ukim.mk.carrent.model.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class InMemoryData {

    public static final List<Car> cars = new ArrayList<>();

    public static final List<Renter> renters = new ArrayList<>();

    public static final List<Client> clients = new ArrayList<>();

    public static final List<CarLog> carlogs = new ArrayList<>();

    public static final List<Reservation> reservations = new ArrayList<>();


    @PostConstruct
    public void init(){

        Renter r1 = new Renter("2312995464019", "Robert Nikolson", 42, Sex.male);
        Renter r2 = new Renter("2312995464020", "Johan Kolak", 52, Sex.male);
        Renter r3 = new Renter("2312995464021", "Piter Gregor", 62, Sex.unoriented);
        Renter r4 = new Renter("2312995464022", "Ellen Gobert", 32, Sex.female);

        Client c1 = new Client("1012995464019", "Roni Chank", 42, Sex.male, "A42X888", true);
        Client c2 = new Client("1112995464019", "Kolana Wobert", 42, Sex.female, "B42X889", false);
        Client c3 = new Client("1212995464019", "Maria Miriam", 42, Sex.female, "C42X887", false);
        Client c4 = new Client("1312995464019", "Nikola Jokic", 42, Sex.male, "D42X886", false);
        Client c5 = new Client("1412995464019", "Slavei Kojac", 42, Sex.unoriented, "E42X885", true);

        Car car1 = new Car("NY-323-UU", "Ford", "Focus", "Red", 2005, 38, 3.0, 3, r1);
        Car car2 = new Car("NY-333-UU", "Ford", "Mondeo", "Blue", 2010, 50, 4.0, 4, r1);
        Car car3 = new Car("BS-111-UU", "Honda", "Civic", "Grat", 2011, 60, 4.0, 4, r2);
        Car car4 = new Car("BS-123-UU", "Kia", "Sportage", "Red", 2014, 80, 5.0, 5, r2);
        Car car5 = new Car("BS-321-UU", "Hyundai", "Tucson", "Black", 2013, 70, 4.0, 4, r2);
        Car car6 = new Car("KK-223-UU", "Kia", "Rio", "Red", 2015, 70, 4.0, 4, r3);
        Car car7 = new Car("ES-323-UU", "Audi", "Q5", "Yellow", 2016, 100, 3.0, 3, r4);

        CarLog cl1 = new CarLog(0, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car1);
        CarLog cl2 = new CarLog(1, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car2);
        CarLog cl3 = new CarLog(2, (LocalDate.of(2019, Month.APRIL,4)), "excellent", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car3);
        CarLog cl4 = new CarLog(3, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car4);
        CarLog cl5 = new CarLog(4, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "excellent", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car5);
        CarLog cl6 = new CarLog(5, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "middle", "poor", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car6);
        CarLog cl7 = new CarLog(6, (LocalDate.of(2019, Month.APRIL,4)), "excellent", "excellent", "excellent", "excellent", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car7);

        reservations.add(Reservation.createReservation(c1, r2, car4, "some comment", LocalDate.of(2020, Month.APRIL, 12), LocalDate.of(2020, Month.APRIL, 20)));
        reservations.add(Reservation.createReservation(c2, r4, car7, "some comment", LocalDate.of(2020, Month.APRIL, 12), LocalDate.of(2020, Month.APRIL, 20)));


    }
}
