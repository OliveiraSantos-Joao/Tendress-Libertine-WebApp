package org.TenderessLibertine.services;


import org.TenderessLibertine.persistence.dao.CustomerDao;
import org.TenderessLibertine.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private CustomerDao customerDao;

    /**
     * Sets the customer data access object
     *
     * @param customerDao the account DAO to set
     */
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * @see CustomerService#save(Customer)
     */
    @Transactional
    public Customer save(Customer customer) {
        return customerDao.saveOrUpdate(customer);
    }

    public List<Customer> list() {
        return customerDao.findAll();
    }

}
