package dev.jpa.repository.Impl;

import dev.jpa.configuration.EntityManagerConfiguration;
import dev.jpa.model.entity.Booking;
import dev.jpa.repository.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager;

    public BookingRepositoryImpl() {
        this.entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<Booking> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Booking.class, id));
    }

    @Override
    public List<Booking> findAll() {
        TypedQuery<Booking> query = entityManager.createQuery("SELECT b FROM Booking b", Booking.class);
        return query.getResultList();
    }

    @Override
    public void save(Booking booking) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            boolean exists = entityManager.find(Booking.class, booking.getId()) != null;

            if (exists) {
                entityManager.merge(booking);
            } else {
                entityManager.persist(booking);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error saving Booking", e);
        }
    }

    @Override
    public void delete(Booking booking) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Booking managedBooking = entityManager.merge(booking);
            entityManager.remove(managedBooking);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error deleting Booking", e);
        }
    }
}
