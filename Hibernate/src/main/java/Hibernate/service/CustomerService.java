package Hibernate.service;

import Hibernate.entity.CustomerDto;

public interface CustomerService {

    public boolean saveCustomer(CustomerDto customerDto);
    public String findCustomer(int key);
}
