package dev.jpa.repository.Impl;

import dev.jpa.configuration.EntityManagerConfiguration;
import dev.jpa.model.entity.UserDetails;
import dev.jpa.repository.UserDetailsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class UserDetailsRepositoryImpl implements UserDetailsRepository{
    private final EntityManager entityManager;

    public UserDetailsRepositoryImpl() {
        this.entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<UserDetails> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(UserDetails.class, id));
    }

    @Override
    public List<UserDetails> findAll() {
        TypedQuery<UserDetails> query = entityManager.createQuery("SELECT ud FROM UserDetails ud", UserDetails.class);
        return query.getResultList();
    }

    @Override
    public void save(UserDetails userDetails) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            boolean exists = entityManager.find(UserDetails.class, userDetails.getId()) != null;

            if (exists) {
                entityManager.merge(userDetails);
            } else {
                entityManager.persist(userDetails);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error saving UserDetails", e);
        }
    }

    @Override
    public void delete(UserDetails userDetails) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UserDetails managedUserDetails = entityManager.merge(userDetails);
            entityManager.remove(managedUserDetails);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error deleting UserDetails", e);
        }
    }
}
