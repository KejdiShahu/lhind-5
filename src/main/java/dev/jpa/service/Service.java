package dev.jpa.service;

import dev.jpa.model.DTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface Service<ENTITY> {
    Optional<ENTITY> findById(Integer id);
    List<ENTITY> findAll();
    void save(ENTITY entity);
    void delete(ENTITY entity);
}
