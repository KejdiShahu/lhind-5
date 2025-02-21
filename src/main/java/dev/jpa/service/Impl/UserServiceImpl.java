package dev.jpa.service.Impl;

import dev.jpa.mapper.UserMapper;
import dev.jpa.model.DTO.UserDTO;
import dev.jpa.repository.UserRepository;
import dev.jpa.repository.Impl.UserRepositoryImpl;
import dev.jpa.service.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements Service<UserDTO> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
        this.userMapper = new UserMapper();
    }

    @Override
    public Optional<UserDTO> findById(Integer id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(UserDTO user) {
        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public void delete(UserDTO user) {
        userRepository.delete(userMapper.toEntity(user));
    }
}
