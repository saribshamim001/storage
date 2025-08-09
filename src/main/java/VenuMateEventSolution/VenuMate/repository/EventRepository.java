package VenuMateEventSolution.VenuMate.repository;

import VenuMateEventSolution.VenuMate.model.VenuesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<VenuesList, Integer> {


}
