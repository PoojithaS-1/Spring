package com.xworkz.restaurantapp.repository;

import com.xworkz.restaurantapp.entity.RestaurantEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class RestaurantRepoImpl implements RestaurantRepo{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(RestaurantEntity restaurantEntity) {

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(restaurantEntity);
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
    public RestaurantEntity getById(Integer restaurantId) {
        EntityManager entityManager=emf.createEntityManager();
        return entityManager.find(RestaurantEntity.class,restaurantId);
    }

    @Override
    public RestaurantEntity getByNoOfTabels(Integer noOfTables) {
        EntityManager entityManager = emf.createEntityManager();
        Query getByNoOfTables = entityManager.createNamedQuery("getByNoOfTables");
        getByNoOfTables.setParameter("noOfTables", noOfTables);
        try {
            RestaurantEntity singleResult = (RestaurantEntity) getByNoOfTables.getSingleResult();
            return singleResult;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;      }

    @Override
    public RestaurantEntity getByName(String restaurantName) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByName=entityManager.createNamedQuery("getByName");
        getByName.setParameter("restaurantName", restaurantName);
        try {
            RestaurantEntity singleResult=(RestaurantEntity) getByName.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;    }

    @Override
    public Integer updateByName(String restaurantName, Integer noOfTables) {
        EntityManager entityManager= emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateByName=entityManager.createNamedQuery("updateByName");
            updateByName.setParameter("noOfTables",noOfTables);
            updateByName.setParameter("restaurantName",restaurantName);
            int row=updateByName.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }return 0;     }

    @Override
    public Integer updateById(Integer restaurantId, Integer noOfTables) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateById = entityManager.createNamedQuery("updateById");
            updateById.setParameter("noOfTables", noOfTables);
            updateById.setParameter("restaurantId", restaurantId);
            int row = updateById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;      }

    @Override
    public Integer deleteById(Integer restaurantId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query deleteById = entityManager.createNamedQuery("deleteById");
            deleteById.setParameter("restaurantId", restaurantId);
            int row = deleteById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;    }

    @Override
    public List<RestaurantEntity> getAllData() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createNamedQuery("getAllData", RestaurantEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }
}
