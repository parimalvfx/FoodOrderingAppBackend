package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * PaymentDao class provides the database access for all the endpoints in payment controller
 */
@Repository
public class PaymentDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * This method helps find all available payment methods
     *
     * @return List<PaymentEntity> object
     */
    public List<PaymentEntity> getAllPaymentMethods() {
        try {
            return entityManager.createNamedQuery("allPaymentMethods", PaymentEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
