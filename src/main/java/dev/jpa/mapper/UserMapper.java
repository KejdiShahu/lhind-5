package dev.jpa.mapper;

import dev.jpa.model.DTO.UserDTO;
import dev.jpa.model.entity.User;

public class UserMapper extends AbstractMapper<User, UserDTO>{
    @Override
    public User toEntity(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getUserRole(),
                userDTO.getUserDetails(),
                userDTO.getBooking()
        );
    }

    @Override
    public UserDTO toDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getUserRole(),
                user.getUserDetails(),
                user.getBooking()
        );
    }
}
