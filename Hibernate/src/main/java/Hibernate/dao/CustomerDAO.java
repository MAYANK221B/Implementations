package Hibernate.dao;

import Hibernate.entity.CustomerDto;

public interface CustomerDAO {

    public void save(CustomerDto theCustomer);
    public CustomerDto findById(int id);
}
