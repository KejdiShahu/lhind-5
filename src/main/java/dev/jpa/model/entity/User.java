package dev.jpa.model.entity;

import dev.jpa.model.enums.UserRole;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetails userDetails;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public User() {}

    public User(int id, String username, String password, UserRole userRole, UserDetails userDetails, List<Booking> bookings) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userDetails = userDetails;
        this.bookings = bookings;
    }

    public User(String username, String password, UserRole userRole, UserDetails userDetails, List<Booking> bookings) {
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

    public void setBooking(List<Booking> bookings) {
        this.bookings = bookings;
    }

}
