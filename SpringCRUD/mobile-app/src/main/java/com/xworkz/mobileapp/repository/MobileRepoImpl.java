package com.xworkz.mobileapp.repository;

import com.xworkz.mobileapp.entity.MobileEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class MobileRepoImpl implements MobileRepo{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(MobileEntity mobileEntity) {

        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mobileEntity);
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
    public MobileEntity getById(Integer id) {
        EntityManager entityManager=emf.createEntityManager();
        return entityManager.find(MobileEntity.class,id);
    }

    @Override
    public MobileEntity getByBrand(String brand) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByBrand =entityManager.createNamedQuery("getByBrand");
        getByBrand.setParameter("brand", brand);
        try {
            MobileEntity singleResult=(MobileEntity) getByBrand.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Integer updateByBrand(String brand, String model) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateByBrand = entityManager.createNamedQuery("updateByBrand");
            updateByBrand.setParameter("model", model);
            updateByBrand.setParameter("brand", brand);
            int row = updateByBrand.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
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
    public Integer updateById(Integer id, String model) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateById = entityManager.createNamedQuery("updateById");
            updateById.setParameter("model", model);
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
    public MobileEntity getByModel(String model) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByEModel =entityManager.createNamedQuery("getByModel");
        getByEModel.setParameter("model", model);
        try {
            MobileEntity singleResult=(MobileEntity) getByEModel.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<MobileEntity> getAllData() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createNamedQuery("getAllData", MobileEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }
}
