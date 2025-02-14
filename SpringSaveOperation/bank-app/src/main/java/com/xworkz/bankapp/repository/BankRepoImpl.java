package com.xworkz.bankapp.repository;

import com.xworkz.bankapp.entity.BankEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class BankRepoImpl implements BankRepo{

    @Override
    public Boolean save(BankEntity bankEntity) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bankEntity);
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