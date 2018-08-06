package pl.sda.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.reservation.model.ReservationEvent;

public interface ReservationEventRepository extends JpaRepository<ReservationEvent, Long> {
}
