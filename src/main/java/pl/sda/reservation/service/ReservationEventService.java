package pl.sda.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.reservation.model.ReservationEvent;
import pl.sda.reservation.repository.ReservationEventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationEventService {

    // powiazuje repozytorium
    @Autowired
    private ReservationEventRepository reservationEventRepository;

    // oddaje metode do dodawania
    public void add(ReservationEvent event){
        // zapisuje nowe wydarzenie
        reservationEventRepository.save(event);
    }

    public List<ReservationEvent> getAllEvents() {
        return reservationEventRepository.findAll();
    }

    public void removeEvent(Long id) {
        reservationEventRepository.deleteById(id);
    }

    public Optional<ReservationEvent> find(Long id) {
        return reservationEventRepository.findById(id);
    }
}
