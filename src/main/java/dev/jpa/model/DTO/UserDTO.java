package dev.jpa.model.DTO;

import dev.jpa.model.entity.Booking;
import dev.jpa.model.entity.UserDetails;
import dev.jpa.model.enums.UserRole;

import java.util.List;

public class UserDTO {
    private int id;
    private String username;
    private String password;
    private UserRole userRole;
    private UserDetails userDetails;
    private List<Booking> bookings;

    public UserDTO() {}

    public UserDTO(int id, String username, String password, UserRole userRole, UserDetails userDetails, List<Booking> bookings) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userDetails = userDetails;
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<Booking> getBooking() {
        return bookings;
    }

    public void setBooking(Booking booking) {
        this.bookings = bookings;
    }

}
