package VenuMateEventSolution.VenuMate.DTO;

public class BookedVenues {
    private Integer bookingVenueId;
    private String bookingDate;
    private String name;

    // Constructor
    public BookedVenues(Integer bookingVenueId, String bookingDate, String name) {
        this.bookingVenueId = bookingVenueId;
        this.bookingDate = bookingDate;
        this.name = name;
    }

    // Getters and Setters
    public Integer getBookingVenueId() {
        return bookingVenueId;
    }

    public void setBookingVenueId(Integer bookingVenueId) {
        this.bookingVenueId = bookingVenueId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
