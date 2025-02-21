package dev.jpa.repository.Impl;

import dev.jpa.configuration.EntityManagerConfiguration;
import dev.jpa.model.entity.Flight;
import dev.jpa.repository.FlightRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class FlightRepositoryImpl implements FlightRepository {
    private final EntityManager entityManager;

    public FlightRepositoryImpl() {
        this.entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<Flight> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Flight.class, id));
    }

    @Override
    public List<Flight> findAll() {
        TypedQuery<Flight> query = entityManager.createQuery("SELECT f FROM Flight f", Flight.class);
        return query.getResultList();
    }

    @Override
    public void save(Flight flight) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            boolean exists = entityManager.find(Flight.class, flight.getId()) != null;

            if (exists) {
                entityManager.merge(flight);
            } else {
                entityManager.persist(flight);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error saving Flight", e);
        }
    }

    @Override
    public void delete(Flight flight) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Flight managedFlight = entityManager.merge(flight); // Attach to persistence context
            entityManager.remove(managedFlight);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error deleting Flight", e);
        }
    }
}
