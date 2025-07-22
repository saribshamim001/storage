package VenuMateEventSolution.VenuMate.model;

import jakarta.persistence.*;


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


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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

}
