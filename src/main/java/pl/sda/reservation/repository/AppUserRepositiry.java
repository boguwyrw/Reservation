package pl.sda.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.reservation.model.AppUser;

import java.util.Optional;

public interface AppUserRepositiry extends JpaRepository<AppUser, Long> {

//    @Query(nativeQuery = "select * from 1?");
    // public

    Optional<AppUser> findByUsername(String username);
}
