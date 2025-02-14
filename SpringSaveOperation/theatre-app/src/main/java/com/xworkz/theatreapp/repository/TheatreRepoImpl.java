package com.xworkz.theatreapp.repository;

import com.xworkz.theatreapp.entity.TheatreEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class TheatreRepoImpl implements TheatreRepo{

    @Override
    public Boolean save(TheatreEntity theatreEntity) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(theatreEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return false;
            } else {
                return false;
            }
        } finally {
            entityManager.close();
        }
    }
}