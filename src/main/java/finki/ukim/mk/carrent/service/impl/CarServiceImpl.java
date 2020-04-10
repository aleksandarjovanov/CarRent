package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Reservation;
import finki.ukim.mk.carrent.model.exceptions.InvalidCarException;
import finki.ukim.mk.carrent.model.exceptions.InvalidRenterException;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.RenterRepository;
import finki.ukim.mk.carrent.service.CarService;
import finki.ukim.mk.carrent.service.ReservationService;
import finki.ukim.mk.carrent.service.TerminService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final RenterRepository renterRepository;
    private final TerminService terminService;
    private final ReservationService reservationService;

    public CarServiceImpl(CarRepository carRepository, RenterRepository renterRepository, TerminService terminService, ReservationService reservationService) {
        this.carRepository = carRepository;
        this.renterRepository = renterRepository;
        this.terminService = terminService;
        this.reservationService = reservationService;
    }

    @Override
    public Car findById(Long carId) {
        this.terminService.checkTerminChanges(carId);
        return this.carRepository.findById(carId).orElseThrow(InvalidCarException::new);
    }

    @Override
    public Car createCar(String plate, String mark, String model, String color, int yearOfProduction, int cost, String imgLink, Long renterId) {
        Renter renter = this.renterRepository.findById(renterId).orElseThrow(InvalidRenterException::new);
        Car car = new Car();
        car.createCar(plate, mark, model, color, yearOfProduction, cost, imgLink, 0.0, 0, renter);
        this.carRepository.save(car);
        this.terminService.createTermin(LocalDate.now(), LocalDate.of(2022, Month.APRIL, 1), car.getId());
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        return this.carRepository.getAllCars();
    }

    @Override
    public List<Car> searchCarsByMark(String mark) {
        return this.carRepository.searchCarsByMark(mark);
    }

    @Override
    public void deleteById(Long carId) {
        List<Reservation> reservations = this.reservationService.getReservationsByCarId(carId);
        this.reservationService.deleteAll(reservations);
        this.carRepository.deleteById(carId);
    }

    @Override
    public void setRating(Long carId, int rating) {
        Car car = this.carRepository.findById(carId).orElseThrow(InvalidCarException::new);
        car.calculateRating(rating);
        this.carRepository.save(car);
    }

    @Override
    public List<Car> getAllOwnedCarsById(Long renterId) {
        return this.carRepository.getAllOwnedCarsByRenterId(renterId);
    }

    @Override
    public Car editCar(Long carId, String plate, String mark, String model, String color, int yearOfProduction, int cost, String imgLink, Long renterId) {
        Car car = findById(carId);
        Renter renter = this.renterRepository.findById(renterId).orElseThrow(InvalidRenterException::new);
        car.createCar(plate, mark, model, color, yearOfProduction, cost, imgLink, car.getRating(), car.getNumberOfRatings(), renter);
        return this.carRepository.save(car);
    }

}
