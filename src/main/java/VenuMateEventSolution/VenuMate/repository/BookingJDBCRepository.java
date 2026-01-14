package VenuMateEventSolution.VenuMate.repository;

import VenuMateEventSolution.VenuMate.DTO.BookedVenues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingJDBCRepository {
    @Autowired
    private JdbcClient jdbcClient;

    public List<BookedVenues> findBookedVenuesDetails() {
        return jdbcClient.sql("select booking_venue_id, booking_date, name from bookings")
                .query(BookedVenues.class)   // map directly to DTO
                .list();                       // returns List<BookedVenueDTO>
    }
}