package dev.jpa.model.entity;

import dev.jpa.model.enums.FlightStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "airline", nullable = false)
    private String airline;

    @Column(name = "flight_number", nullable = false)
    private int flightNumber;

    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

    @Column(name = "arrival_date", nullable = false)
    private Date arrivalDate;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Flight() {}

    public Flight(int id, String origin, String destination, String airline, int flightNumber, Date departureDate, Date arrivalDate, FlightStatus flightStatus, List<Booking> bookings) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightStatus = flightStatus;
        this.bookings = bookings;
    }

    public Flight(String origin, String destination, String airline, int flightNumber, Date departureDate, Date arrivalDate, FlightStatus flightStatus, List<Booking> bookings) {
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightStatus = flightStatus;
        this.bookings = bookings;
    }

    public List<Booking> getBooking() {
        return bookings;
    }

    public void setBooking(List<Booking> booking) {
        this.bookings = booking;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
