package com.xworkz.countryapp.repository;

import com.xworkz.countryapp.entity.CountryEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class CountryRepositoryImpl implements CountryRepository{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(CountryEntity countryEntity) {

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

    @Override
    public CountryEntity getById(Integer countryId) {
        EntityManager entityManager=emf.createEntityManager();
        return entityManager.find(CountryEntity.class,countryId);
    }

    @Override
    public CountryEntity getByNoOfStates(Integer noOfStates) {
        EntityManager entityManager = emf.createEntityManager();
        Query getByName = entityManager.createNamedQuery("getByNoOfStates");
        getByName.setParameter("noOfStates", noOfStates);
        try {
            CountryEntity singleResult = (CountryEntity) getByName.getSingleResult();
            return singleResult;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;    }

    @Override
    public CountryEntity getByName(String countryName) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByName=entityManager.createNamedQuery("getByName");
        getByName.setParameter("countryName", countryName);
        try {
            CountryEntity singleResult=(CountryEntity) getByName.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Integer updateByName(String countryName, Integer noOfStates) {
        EntityManager entityManager= emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateByName=entityManager.createNamedQuery("updateByName");
            updateByName.setParameter("noOfStates",noOfStates);
            updateByName.setParameter("countryName",countryName);
            int row=updateByName.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }return 0;    }

    @Override
    public Integer updateById(Integer countryId, Integer noOfStates) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateById = entityManager.createNamedQuery("updateById");
            updateById.setParameter("noOfStates", noOfStates);
            updateById.setParameter("countryId", countryId);
            int row = updateById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;    }

    @Override
    public Integer deleteById(Integer countryId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query deleteById = entityManager.createNamedQuery("deleteById");
            deleteById.setParameter("countryId", countryId);
            int row = deleteById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;    }

    @Override
    public List<CountryEntity> getAllData() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createNamedQuery("getAllData", CountryEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }
}
