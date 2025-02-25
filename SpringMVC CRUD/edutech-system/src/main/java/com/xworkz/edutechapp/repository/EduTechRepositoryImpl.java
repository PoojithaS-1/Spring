package com.xworkz.edutechapp.repository;

import com.xworkz.edutechapp.entity.EduTechEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class EduTechRepositoryImpl implements EdutechRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(EduTechEntity eduTechEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(eduTechEntity);
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
    public List<EduTechEntity> getAllTraineeInfo() {
        EntityManager entityManager = emf.createEntityManager();

        try {
            return entityManager.createNamedQuery("getAllTraineeInfo").getResultList();

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
