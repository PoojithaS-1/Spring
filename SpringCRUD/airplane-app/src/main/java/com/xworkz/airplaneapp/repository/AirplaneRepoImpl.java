package com.xworkz.airplaneapp.repository;

import com.xworkz.airplaneapp.entity.AirplaneEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class AirplaneRepoImpl implements AirplaneRepo{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(AirplaneEntity airplaneEntity) {

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(airplaneEntity);
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
    public AirplaneEntity getById(Integer airplaneId) {
        EntityManager entityManager=emf.createEntityManager();
        return entityManager.find(AirplaneEntity.class,airplaneId);
    }

    @Override
    public AirplaneEntity getByNoOfSeats(Integer noOfSeats) {
        EntityManager entityManager = emf.createEntityManager();
        Query getByNoOfSeats = entityManager.createNamedQuery("getByNoOfSeats");
        getByNoOfSeats.setParameter("noOfSeats", noOfSeats);
        try {
            AirplaneEntity singleResult = (AirplaneEntity) getByNoOfSeats.getSingleResult();
            return singleResult;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    @Override
    public AirplaneEntity getByModel(String airplaneModel) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByModel =entityManager.createNamedQuery("getByModel");
        getByModel.setParameter("airplaneModel", airplaneModel);
        try {
            AirplaneEntity singleResult=(AirplaneEntity) getByModel.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;    }

    @Override
    public Integer updateByModel(String airplaneModel, Integer noOfSeats) {
        EntityManager entityManager= emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateByModel =entityManager.createNamedQuery("updateByModel");
            updateByModel.setParameter("noOfSeats",noOfSeats);
            updateByModel.setParameter("airplaneModel",airplaneModel);
            int row=updateByModel.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }return 0;       }

    @Override
    public Integer updateById(Integer airplaneId, Integer noOfSeats) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateById = entityManager.createNamedQuery("updateById");
            updateById.setParameter("noOfSeats", noOfSeats);
            updateById.setParameter("airplaneId", airplaneId);
            int row = updateById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;    }

    @Override
    public Integer deleteById(Integer airplaneId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query deleteById = entityManager.createNamedQuery("deleteById");
            deleteById.setParameter("airplaneId", airplaneId);
            int row = deleteById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;     }

    @Override
    public List<AirplaneEntity> getAllData() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createNamedQuery("getAllData", AirplaneEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }
}