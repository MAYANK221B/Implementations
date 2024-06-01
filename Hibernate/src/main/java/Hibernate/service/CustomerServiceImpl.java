package Hibernate.service;

import Hibernate.entity.CustomerDto;
import Hibernate.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public boolean saveCustomer(CustomerDto customerDto) {
        try {
            customerDAO.save(customerDto);
        } catch (Exception e) {
            System.out.println("Customer saving operation failed");
            return false;
        }
        System.out.println("Customer saving operation successful");
        return true;
    }

    @Override
    public String findCustomer(int key) {
        CustomerDto customerDetail = customerDAO.findById(key);
        return customerDetail.toString();
    }
}
