package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.HealthCardEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;
@Repository
public class HealthCardRepositoryImpl implements HealthCardRepository{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(HealthCardEntity healthCardEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(healthCardEntity);
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

    @Override
    public List<HealthCardEntity> getAllApplicantInfo() {
        EntityManager entityManager = emf.createEntityManager();

        try {
            return entityManager.createNamedQuery("getAllApplicantInfo").getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
    }
}
