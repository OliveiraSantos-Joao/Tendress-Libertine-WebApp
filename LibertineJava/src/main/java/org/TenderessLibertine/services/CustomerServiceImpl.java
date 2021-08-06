package org.TenderessLibertine.services;


import org.TenderessLibertine.exceptions.AssociationExistsException;
import org.TenderessLibertine.exceptions.CustomerNotFoundException;
import org.TenderessLibertine.persistence.dao.CustomerDao;
import org.TenderessLibertine.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;


    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return customerDao.saveOrUpdate(customer);
    }

    @Override
    public void delete(Integer id) throws AssociationExistsException, CustomerNotFoundException {

    }

    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }


    @Override
    public List<Customer> list() {
        return customerDao.findAll();
    }

}
