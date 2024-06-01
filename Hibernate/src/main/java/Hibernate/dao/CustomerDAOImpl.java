package Hibernate.dao;

import Hibernate.entity.CustomerDto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(CustomerDto theCustomer) {
            entityManager.persist(theCustomer);
    }

    @Override
    public CustomerDto findById(int id) {
           return entityManager.find(CustomerDto.class, 1);
    }

}
