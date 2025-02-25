package com.xworkz.userapp.repository;

import com.xworkz.userapp.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean saveUser(UserEntity userEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userEntity);
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
    public List<UserEntity> getAllUserInfo() {
        EntityManager entityManager= emf.createEntityManager();

        try {
            return entityManager.createNamedQuery("getAllUserInfo").getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(Integer id) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();

    }
}
