package dev.jpa.model.DTO;

import dev.jpa.model.entity.Flight;
import dev.jpa.model.entity.User;
import dev.jpa.model.enums.BookingStatus;

import java.util.Date;

public class BookingDTO {
    private int id;
    private Date bookingDate;
    private BookingStatus bookingStatus;
    private User user;
    private Flight flight;

    public BookingDTO() {}

    public BookingDTO(int id, Date bookingDate, BookingStatus bookingStatus, User user, Flight flight) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.flight = flight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}
