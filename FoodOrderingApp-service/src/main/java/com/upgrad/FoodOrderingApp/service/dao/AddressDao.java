package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * AddressDao class provides the database access for all the endpoints in address controller
 */
@Repository
public class AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    public AddressEntity createAddress(AddressEntity addressEntity) {
        entityManager.persist(addressEntity);
        return addressEntity;
    }

    /**
     * This method helps fetch all saved addresses
     *
     * @return List<AddressEntity> object
     */
    public List<AddressEntity> getAllAddresses() {
        try {
            return entityManager.createNamedQuery("allAddresses", AddressEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * This method helps to fetch address by id
     *
     * @return AddressEntity object
     */
    public AddressEntity getAddressById(String uuid) {
        try {
            return entityManager.createNamedQuery("getAddressbyId", AddressEntity.class).setParameter("UUID", uuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
