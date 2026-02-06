package VenuMateEventSolution.VenuMate.repository;

import VenuMateEventSolution.VenuMate.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    boolean existsByVenue_IdAndBookingDate(Integer venueId, LocalDate bookingDate);
}
