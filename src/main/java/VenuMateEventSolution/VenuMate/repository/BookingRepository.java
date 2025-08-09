package VenuMateEventSolution.VenuMate.repository;

import VenuMateEventSolution.VenuMate.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
