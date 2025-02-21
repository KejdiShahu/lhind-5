package dev.jpa.service.Impl;

import dev.jpa.mapper.FlightMapper;
import dev.jpa.model.DTO.FlightDTO;
import dev.jpa.repository.FlightRepository;
import dev.jpa.repository.Impl.FlightRepositoryImpl;
import dev.jpa.service.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightServiceImpl implements Service<FlightDTO> {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public FlightServiceImpl() {
        this.flightRepository = new FlightRepositoryImpl();
        this.flightMapper = new FlightMapper();
    }

    @Override
    public Optional<FlightDTO> findById(Integer id) {
        return flightRepository.findById(id).map(flightMapper::toDto);
    }

    @Override
    public List<FlightDTO> findAll() {
        return flightRepository.findAll().stream().map(flightMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(FlightDTO flight) {
        flightRepository.save(flightMapper.toEntity(flight));
    }

    @Override
    public void delete(FlightDTO flight) {
        flightRepository.delete(flightMapper.toEntity(flight));
    }
}
