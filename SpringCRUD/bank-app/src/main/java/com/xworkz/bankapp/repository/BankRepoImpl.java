package com.xworkz.bankapp.repository;

import com.xworkz.bankapp.entity.BankEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class BankRepoImpl implements BankRepo{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(BankEntity bankEntity) {

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

    @Override
    public BankEntity getById(Integer bankId) {
        EntityManager entityManager=emf.createEntityManager();
        return entityManager.find(BankEntity.class,bankId);
    }

    @Override
    public BankEntity getByNoOfBranches(Integer noOfBranches) {
        EntityManager entityManager = emf.createEntityManager();
        Query getByNoOfBranches = entityManager.createNamedQuery("getByNoOfBranches");
        getByNoOfBranches.setParameter("noOfBranches", noOfBranches);
        try {
            BankEntity singleResult = (BankEntity) getByNoOfBranches.getSingleResult();
            return singleResult;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;      }

    @Override
    public BankEntity getByName(String bankName) {
        EntityManager entityManager=emf.createEntityManager();
        Query getByName=entityManager.createNamedQuery("getByName");
        getByName.setParameter("bankName", bankName);
        try {
            BankEntity singleResult=(BankEntity) getByName.getSingleResult();
            return singleResult;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;    }

    @Override
    public Integer updateByName(String bankName, Integer noOfBranches) {
        EntityManager entityManager= emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateByName=entityManager.createNamedQuery("updateByName");
            updateByName.setParameter("noOfBranches",noOfBranches);
            updateByName.setParameter("bankName",bankName);
            int row=updateByName.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }return 0;    }

    @Override
    public Integer updateById(Integer bankId, Integer noOfBranches) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query updateById = entityManager.createNamedQuery("updateById");
            updateById.setParameter("noOfBranches", noOfBranches);
            updateById.setParameter("bankId", bankId);
            int row = updateById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }

    @Override
    public Integer deleteById(Integer bankId) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query deleteById = entityManager.createNamedQuery("deleteById");
            deleteById.setParameter("bankId", bankId);
            int row = deleteById.executeUpdate();
            entityManager.getTransaction().commit();
            return row;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;     }

    @Override
    public List<BankEntity> getAllData() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createNamedQuery("getAllData", BankEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }
}