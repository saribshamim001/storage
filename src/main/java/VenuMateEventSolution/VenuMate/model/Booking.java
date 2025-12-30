package VenuMateEventSolution.VenuMate.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int capacity;
    private String timeslot;
    private String decoration;
    private String stage;
    private String flowers;


    @Column(name = "bookingDate", nullable = false)
    private LocalDate bookingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingVenueId", nullable = false)
    private VenuesList venue;

    // ===== Getters & Setters =====

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getTimeslot() {
        return timeslot;
    }
    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }
    public String getDecoration() {
        return decoration;
    }
    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }
    public String getStage() {
        return stage;
    }
    public void setStage(String stage) {
        this.stage = stage;
    }
    public String getFlowers() {
        return flowers;
    }
    public void setFlowers(String flowers) {
        this.flowers = flowers;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public VenuesList getVenue() {
        return venue;
    }
    public void setVenue(VenuesList venue) {
        this.venue = venue;
    }
}
