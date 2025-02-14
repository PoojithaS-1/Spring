package com.xworkz.countryapp.repository;

import com.xworkz.countryapp.entity.CountryEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
@Component
public class CountryRepositoryImpl implements CountryRepository{
    @Override
    public Boolean save(CountryEntity countryEntity) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(countryEntity);
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
