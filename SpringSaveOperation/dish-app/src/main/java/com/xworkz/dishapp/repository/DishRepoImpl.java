package com.xworkz.dishapp.repository;

import com.xworkz.dishapp.entity.DishEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@Component
public class DishRepoImpl implements DishRepo{

    @Override
    public Boolean save(DishEntity dishEntity) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(dishEntity);
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