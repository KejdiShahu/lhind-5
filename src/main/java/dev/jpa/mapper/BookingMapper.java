package dev.jpa.mapper;

import dev.jpa.model.DTO.BookingDTO;
import dev.jpa.model.entity.Booking;

public class BookingMapper extends AbstractMapper<Booking, BookingDTO> {
    @Override
    public Booking toEntity(BookingDTO bookingDTO) {
        return new Booking(
                bookingDTO.getId(),
                bookingDTO.getBookingDate(),
                bookingDTO.getBookingStatus(),
                bookingDTO.getUser(),
                bookingDTO.getFlight()
        );
    }

    @Override
    public BookingDTO toDto(Booking booking) {
        return new BookingDTO(
                booking.getId(),
                booking.getBookingDate(),
                booking.getBookingStatus(),
                booking.getUser(),
                booking.getFlight()
        );
    }
}
