package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Reservation;
import finki.ukim.mk.carrent.model.exceptions.InvalidCarException;
import finki.ukim.mk.carrent.model.exceptions.InvalidClientException;
import finki.ukim.mk.carrent.model.exceptions.InvalidReservationException;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.ClientRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.ReservationRepository;
import finki.ukim.mk.carrent.service.ReservationService;
import finki.ukim.mk.carrent.service.TerminService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final TerminService terminService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ClientRepository clientRepository, CarRepository carRepository, TerminService terminService) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.terminService = terminService;
    }

    @Override
    public Reservation findById(Long reservationId) {
        return this.reservationRepository.findById(reservationId).orElseThrow(InvalidReservationException::new);
    }

    @Override
    public Reservation createReservation(Long clientId, Long carId, String comment, LocalDate from, LocalDate to) {
        this.terminService.checkTerminChanges(carId);

        Client client = this.clientRepository.findById(clientId).orElseThrow(InvalidClientException::new);
        Car car = this.carRepository.findById(carId).orElseThrow(InvalidCarException::new);
        Reservation reservation = new Reservation();
        reservation.createReservation(client, car, comment, from, to);

        this.terminService.calculateNewTermines(carId, from, to);

        return this.reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(Long reservationId) {
        this.reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.getAllReservations();
    }

    @Override
    public List<Reservation> getReservationsByClientId(Long clientId) {
        return this.reservationRepository.getReservationsByClientId(clientId);
    }

    @Override
    public List<Reservation> getReservationsByRenterId(Long renterId) {
        return this.reservationRepository.getReservationsByRenterId(renterId);
    }

    @Override
    public List<Reservation> getReservationsByClientName(String name) {
        return this.reservationRepository.getReservationsByClientName(name);
    }

    @Override
    public List<Reservation> getActiveReservations(LocalDate now) {
        return this.reservationRepository.getActiveReservations(now);
    }

}
