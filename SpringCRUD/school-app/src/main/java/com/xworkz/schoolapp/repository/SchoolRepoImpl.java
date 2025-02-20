package com.xworkz.schoolapp.repository;

import com.xworkz.schoolapp.entity.SchoolEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class SchoolRepoImpl implements SchoolRepo{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(SchoolEntity schoolEntity) {

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(schoolEntity);
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
    public SchoolEntity getById(Integer schoolId) {
        EntityManager entityManager=emf.createEntityManager();
        return entityManager.find(SchoolEntity.class,schoolId);
        }

    @Override
    public SchoolEntity getByNoOfClassrooms(Integer noOfClassrooms) {
        EntityManager entityManager = emf.createEntityManager();
        Query getByNoOfClassrooms = entityManager.createNamedQuery("getByNoOfClassrooms");
        getByNoOfClassrooms.setParameter("noOfClassrooms", noOfClassrooms);
        try {
            SchoolEntity singleResult = (SchoolEntity) getByNoOfClassrooms.getSingleResult();
            return singleResult;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;     }

    @Override
    public SchoolEntity getByName(String schoolName) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByName=entityManager.createNamedQuery("getByName");
        getByName.setParameter("schoolName", schoolName);
        try {
            SchoolEntity singleResult=(SchoolEntity) getByName.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;      }

    @Override
    public Integer updateByName(String schoolName, Integer noOfClassrooms) {
        EntityManager entityManager= emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateByName=entityManager.createNamedQuery("updateByName");
            updateByName.setParameter("noOfClassrooms",noOfClassrooms);
            updateByName.setParameter("schoolName",schoolName);
            int row=updateByName.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }return 0;      }

    @Override
    public Integer updateById(Integer schoolId, Integer noOfClassrooms) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateById = entityManager.createNamedQuery("updateById");
            updateById.setParameter("noOfClassrooms", noOfClassrooms);
            updateById.setParameter("schoolId", schoolId);
            int row = updateById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;    }

    @Override
    public Integer deleteById(Integer schoolId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query deleteById = entityManager.createNamedQuery("deleteById");
            deleteById.setParameter("schoolId", schoolId);
            int row = deleteById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;     }

    @Override
    public List<SchoolEntity> getAllData() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createNamedQuery("getAllData", SchoolEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }
}