package com.xworkz.tvapp.repository;

import com.xworkz.tvapp.entity.TvEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@Component
public class TvRepositoryImpl implements TvRepository{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");
    @Override
    public Boolean save(TvEntity tvEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tvEntity);
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
