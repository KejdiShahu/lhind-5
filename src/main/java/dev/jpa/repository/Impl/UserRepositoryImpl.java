package dev.jpa.repository.Impl;

import dev.jpa.configuration.EntityManagerConfiguration;
import dev.jpa.model.entity.User;
import dev.jpa.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    public UserRepositoryImpl() {
        this.entityManager = EntityManagerConfiguration.getEntityManager();
    }


    @Override
    public Optional<User> findById(Integer integer) {
        return Optional.ofNullable(entityManager.find(User.class, integer));
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            boolean exists = entityManager.find(User.class, user.getId()) != null;

            if (exists) {
                entityManager.merge(user);
            } else {
                entityManager.persist(user);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error saving user", e);
        }
    }


    @Override
    public void delete(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User managedUser = entityManager.merge(user);
            entityManager.remove(managedUser);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error deleting user", e);
        }
    }
}
