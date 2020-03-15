package finki.ukim.mk.carrent.model.LocalData;

import finki.ukim.mk.carrent.model.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Getter
public class InMemoryData {

    public static final List<Car> cars = new ArrayList<>();

    public static final List<Renter> renters = new ArrayList<>();

    public static final List<Client> clients = new ArrayList<>();

    public static final List<CarHistory> carHistories = new ArrayList<>();

    public static final List<Reservation> reservations = new ArrayList<>();

    public static final List<Termin> termins = new ArrayList<>();


    @PostConstruct
    public void init(){

        Renter r1 = new Renter("2312995464019", "Robert Nikolson", 42, Sex.male, new ArrayList<>());
        Renter r2 = new Renter("2312995464020", "Johan Kolak", 52, Sex.male, new ArrayList<>());
        Renter r3 = new Renter("2312995464021", "Piter Gregor", 62, Sex.unoriented, new ArrayList<>());
        Renter r4 = new Renter("2312995464022", "Ellen Gobert", 32, Sex.female, new ArrayList<>());

        Client c1 = new Client("1012995464019", "Roni Chank", 42, Sex.male, "A42X888", true, new ArrayList<>());
        Client c2 = new Client("1112995464019", "Kolana Wobert", 42, Sex.female, "B42X889", false, new ArrayList<>());
        Client c3 = new Client("1212995464019", "Maria Miriam", 42, Sex.female, "C42X887", false, new ArrayList<>());
        Client c4 = new Client("1312995464019", "Nikola Jokic", 42, Sex.male, "D42X886", false, new ArrayList<>());
        Client c5 = new Client("1412995464019", "Slavei Kojac", 42, Sex.unoriented, "E42X885", true, new ArrayList<>());

        Car car1 = new Car("NY-323-UU", "Ford", "Focus", "Red", 2005, 38, 3.0, 3, r1);
        Car car2 = new Car("NY-333-UU", "Ford", "Mondeo", "Blue", 2010, 50, 4.0, 4, r1);
        Car car3 = new Car("BS-111-UU", "Honda", "Civic", "Grat", 2011, 60, 4.0, 4, r2);
        Car car4 = new Car("BS-123-UU", "Kia", "Sportage", "Red", 2014, 80, 5.0, 5, r2);
        Car car5 = new Car("BS-321-UU", "Hyundai", "Tucson", "Black", 2013, 70, 4.0, 4, r2);
        Car car6 = new Car("KK-223-UU", "Kia", "Rio", "Red", 2015, 70, 4.0, 4, r3);
        Car car7 = new Car("ES-323-UU", "Audi", "Q5", "Yellow", 2016, 100, 3.0, 3, r4);

        CarHistory cl1 = new CarHistory(0, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car1);
        CarHistory cl2 = new CarHistory(1, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car2);
        CarHistory cl3 = new CarHistory(2, (LocalDate.of(2019, Month.APRIL,4)), "excellent", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car3);
        CarHistory cl4 = new CarHistory(3, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "good", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car4);
        CarHistory cl5 = new CarHistory(4, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "good", "excellent", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car5);
        CarHistory cl6 = new CarHistory(5, (LocalDate.of(2019, Month.APRIL,4)), "good", "excellent", "middle", "poor", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car6);
        CarHistory cl7 = new CarHistory(6, (LocalDate.of(2019, Month.APRIL,4)), "excellent", "excellent", "excellent", "excellent", 240000, "It real sent your at. Amounted all shy set why followed declared. Repeated of endeavor mr position kindness offering ignorant so up. Simplicity are melancholy preference considered saw companions. Disposal on outweigh do speedily in on. Him ham although thoughts entirely drawings. Acceptance unreserved old admiration projection nay yet him. Lasted am so before on esteem vanity oh.", car7);

        termins.add(new Termin(1, LocalDate.now(), LocalDate.of(2025, Month.APRIL, 1), car1));
        termins.add(new Termin(2, LocalDate.now(), LocalDate.of(2025, Month.APRIL, 1), car2));
        termins.add(new Termin(3, LocalDate.now(), LocalDate.of(2025, Month.APRIL, 1), car3));
        termins.add(new Termin(4, LocalDate.now(), LocalDate.of(2025, Month.APRIL, 1), car4));
        termins.add(new Termin(5, LocalDate.now(), LocalDate.of(2025, Month.APRIL, 1), car5));
        termins.add(new Termin(6, LocalDate.now(), LocalDate.of(2025, Month.APRIL, 1), car6));
        termins.add(new Termin(7, LocalDate.now(), LocalDate.of(2025, Month.APRIL, 1), car7));

        renters.add(r1);
        renters.add(r2);
        renters.add(r3);
        renters.add(r4);

        clients.add(c1);
        clients.add(c2);
        clients.add(c3);
        clients.add(c4);
        clients.add(c5);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);

        carHistories.add(cl1);
        carHistories.add(cl2);
        carHistories.add(cl3);
        carHistories.add(cl4);
        carHistories.add(cl5);
        carHistories.add(cl6);
        carHistories.add(cl7);

        c1.follow(r2);
        c1.follow(r1);
        c2.follow(r2);
        c2.follow(r3);
        c2.follow(r4);

        reservations.add(Reservation.createReservation(c1, car4, "some comment", LocalDate.of(2020, Month.APRIL, 12), LocalDate.of(2020, Month.APRIL, 20)));
        reservations.add(Reservation.createReservation(c2, car7, "some comment", LocalDate.of(2020, Month.APRIL, 12), LocalDate.of(2020, Month.APRIL, 20)));


    }
}
