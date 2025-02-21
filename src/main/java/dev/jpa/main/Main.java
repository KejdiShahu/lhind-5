package dev.jpa.main;

import dev.jpa.mapper.UserMapper;
import dev.jpa.model.entity.Booking;
import dev.jpa.model.entity.Flight;
import dev.jpa.model.entity.User;
import dev.jpa.model.entity.UserDetails;
import dev.jpa.model.enums.BookingStatus;
import dev.jpa.model.enums.FlightStatus;
import dev.jpa.model.enums.UserRole;
import dev.jpa.service.Impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserMapper userMapper = new UserMapper();

        User user = new User();
        user.setUsername("kejdi");
        user.setPassword("pass");
        user.setUserRole(UserRole.USER);
        user.setBooking(new ArrayList<>());

        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName("kejdi");
        userDetails.setLastName("shahu");
        userDetails.setEmail("kejdi@gmail.com");
        userDetails.setPhoneNumber("123456789");

        userDetails.setUser(user);
        user.setUserDetails(userDetails);

        Flight flight = new Flight();
        flight.setAirline("America");
        flight.setFlightNumber(12);
        flight.setFlightStatus(FlightStatus.IN_AIR);
        flight.setArrivalDate(new Date());
        flight.setDepartureDate(new Date());
        flight.setOrigin("America");
        flight.setDestination("France");
        flight.setBooking(new ArrayList<>());

        Booking booking = new Booking();
        booking.setBookingDate(new Date());
        booking.setBookingStatus(BookingStatus.BOOKED);

        booking.setUser(user);
        booking.setFlight(flight);

        user.getBooking().add(booking);
        flight.getBooking().add(booking);

        userService.save(userMapper.toDto(user));
    }
}