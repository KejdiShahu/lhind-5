package dev.jpa.service.Impl;

import dev.jpa.mapper.BookingMapper;
import dev.jpa.model.DTO.BookingDTO;
import dev.jpa.repository.BookingRepository;
import dev.jpa.repository.Impl.BookingRepositoryImpl;
import dev.jpa.service.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingServiceImpl implements Service<BookingDTO> {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl() {
        this.bookingRepository = new BookingRepositoryImpl();
        this.bookingMapper = new BookingMapper();
    }

    @Override
    public Optional<BookingDTO> findById(Integer id) {
        return bookingRepository.findById(id).map(bookingMapper::toDto);
    }

    @Override
    public List<BookingDTO> findAll() {
        return bookingRepository.findAll().stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(BookingDTO booking) {
        bookingRepository.save(bookingMapper.toEntity(booking));
    }

    @Override
    public void delete(BookingDTO booking) {
        bookingRepository.delete(bookingMapper.toEntity(booking));
    }
}
