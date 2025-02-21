package dev.jpa.mapper;

import dev.jpa.model.DTO.UserDetailsDTO;
import dev.jpa.model.entity.UserDetails;

public class UserDetailsMapper extends AbstractMapper<UserDetails, UserDetailsDTO>{

    @Override
    public UserDetails toEntity(UserDetailsDTO userDetailsDTO) {
        return new UserDetails(
                userDetailsDTO.getId(),
                userDetailsDTO.getFirstName(),
                userDetailsDTO.getLastName(),
                userDetailsDTO.getEmail(),
                userDetailsDTO.getPhoneNumber(),
                userDetailsDTO.getUser()
        );
    }

    @Override
    public UserDetailsDTO toDto(UserDetails userDetails) {
        return new UserDetailsDTO(
                userDetails.getId(),
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getEmail(),
                userDetails.getPhoneNumber(),
                userDetails.getUser()
        );
    }
}
