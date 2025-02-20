package com.xworkz.theatreapp.repository;

import com.xworkz.theatreapp.entity.TheatreEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class TheatreRepoImpl implements TheatreRepo{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(TheatreEntity theatreEntity) {

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(theatreEntity);
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
    public TheatreEntity getById(Integer id) {
        EntityManager entityManager=emf.createEntityManager();
        return entityManager.find(TheatreEntity.class,id);
    }

    @Override
    public TheatreEntity getByName(String name) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByName=entityManager.createNamedQuery("getByName");
        getByName.setParameter("name", name);
        try {
            TheatreEntity singleResult=(TheatreEntity) getByName.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Integer updateByName(String name, String amenities) {
        EntityManager entityManager= emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateByName=entityManager.createNamedQuery("updateByName");
            updateByName.setParameter("amenities",amenities);
            updateByName.setParameter("name",name);
            int row=updateByName.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }return 0;
    }

    @Override
    public Integer deleteById(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query deleteById = entityManager.createNamedQuery("deleteById");
            deleteById.setParameter("id", id);
            int row = deleteById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Integer updateById(Integer id, String amenities) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateById = entityManager.createNamedQuery("updateById");
            updateById.setParameter("amenities", amenities);
            updateById.setParameter("id", id);
            int row = updateById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }

    @Override
    public TheatreEntity getByAmenities(String amenities) {
        EntityManager entityManager = emf.createEntityManager();
        Query getByName = entityManager.createNamedQuery("getByAmenities");
        getByName.setParameter("amenities", amenities);
        try {
            TheatreEntity singleResult = (TheatreEntity) getByName.getSingleResult();
            return singleResult;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<TheatreEntity> getAllData() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createNamedQuery("getAllData", TheatreEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }
}


