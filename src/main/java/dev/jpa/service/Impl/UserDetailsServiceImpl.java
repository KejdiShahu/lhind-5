package dev.jpa.service.Impl;

import dev.jpa.mapper.UserDetailsMapper;
import dev.jpa.model.DTO.UserDetailsDTO;
import dev.jpa.repository.UserDetailsRepository;
import dev.jpa.repository.Impl.UserDetailsRepositoryImpl;
import dev.jpa.service.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements Service<UserDetailsDTO> {
    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl() {
        this.userDetailsRepository = new UserDetailsRepositoryImpl();
        this.userDetailsMapper = new UserDetailsMapper();
    }

    @Override
    public Optional<UserDetailsDTO> findById(Integer id) {
        return userDetailsRepository.findById(id).map(userDetailsMapper::toDto);
    }

    @Override
    public List<UserDetailsDTO> findAll() {
        return userDetailsRepository.findAll().stream().map(userDetailsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(UserDetailsDTO userDetails) {
        userDetailsRepository.save(userDetailsMapper.toEntity(userDetails));
    }

    @Override
    public void delete(UserDetailsDTO userDetails) {
        userDetailsRepository.delete(userDetailsMapper.toEntity(userDetails));
    }
}
