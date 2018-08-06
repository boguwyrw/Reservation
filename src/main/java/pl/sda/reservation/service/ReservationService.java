package pl.sda.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.reservation.model.CreateReservationDTO;
import pl.sda.reservation.model.Reservation;
import pl.sda.reservation.model.ReservationEvent;
import pl.sda.reservation.model.ReservationStatus;
import pl.sda.reservation.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationEventService reservationEventService;

    public void addReservation(CreateReservationDTO createReservationDTO){
        Optional<ReservationEvent> eventOptional = reservationEventService.find(createReservationDTO.getEventId());

        if(eventOptional.isPresent()){
            ReservationEvent event = eventOptional.get();

            Reservation reservation = new Reservation(null, createReservationDTO.getParticipantName(), event, ReservationStatus.UNCONFIRMED);
            saveReservation(reservation);
        }
    }

    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservation() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> find(Long id) {
        return reservationRepository.findById(id);
    }
}
