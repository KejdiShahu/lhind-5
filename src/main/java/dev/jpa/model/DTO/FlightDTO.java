package dev.jpa.model.DTO;

import dev.jpa.model.entity.Booking;
import dev.jpa.model.enums.FlightStatus;

import java.util.Date;
import java.util.List;

public class FlightDTO {
    private int id;
    private String origin;
    private String destination;
    private String airline;
    private int flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private FlightStatus flightStatus;
    private List<Booking> bookings;

    public FlightDTO() {}

    public FlightDTO(int id, String origin, String destination, String airline, int flightNumber, Date departureDate, Date arrivalDate, FlightStatus flightStatus, List<Booking> bookings) {
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

    public List<Booking> getBooking() {
        return bookings;
    }

    public void setBooking(Booking booking) {
        this.bookings = bookings;
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
