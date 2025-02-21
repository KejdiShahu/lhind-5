package dev.jpa.repository;

import java.util.List;
import java.util.Optional;

public interface Repository <ENTITY, ID>{
    public Optional<ENTITY> findById(ID id);
    public List<ENTITY> findAll();
    public void save(ENTITY entity);
    public void delete(ENTITY entity);
}
