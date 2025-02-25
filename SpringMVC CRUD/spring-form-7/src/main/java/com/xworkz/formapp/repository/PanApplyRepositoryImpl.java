package com.xworkz.formapp.repository;

import com.xworkz.formapp.entity.PanApplyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

@Repository
public class PanApplyRepositoryImpl implements PanApplyRepository{
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(PanApplyEntity panApplyEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(panApplyEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
                return false;
            }else {
                return false;
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<PanApplyEntity> getAllApplicantInfo() {
        EntityManager entityManager= emf.createEntityManager();

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
    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
    }
}
