package dev.jpa.mapper;

import dev.jpa.model.DTO.FlightDTO;
import dev.jpa.model.entity.Flight;

public class FlightMapper extends AbstractMapper<Flight, FlightDTO> {
    @Override
    public Flight toEntity(FlightDTO flightDTO) {
        return new Flight(
                flightDTO.getId(),
                flightDTO.getOrigin(),
                flightDTO.getDestination(),
                flightDTO.getAirline(),
                flightDTO.getFlightNumber(),
                flightDTO.getDepartureDate(),
                flightDTO.getArrivalDate(),
                flightDTO.getFlightStatus(),
                flightDTO.getBooking()
        );
    }

    @Override
    public FlightDTO toDto(Flight flight) {
        return new FlightDTO(
                flight.getId(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getAirline(),
                flight.getFlightNumber(),
                flight.getDepartureDate(),
                flight.getArrivalDate(),
                flight.getFlightStatus(),
                flight.getBooking()
        );
    }
}
