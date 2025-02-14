package com.xworkz.hospitalapp.repository;

import com.xworkz.hospitalapp.entity.HospitalEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class HospitalRepoImpl implements HospitalRepo{

    @Override
    public Boolean save(HospitalEntity hospitalEntity) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(hospitalEntity);
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
