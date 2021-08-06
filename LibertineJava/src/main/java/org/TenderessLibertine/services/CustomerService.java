package org.TenderessLibertine.services;

import org.TenderessLibertine.dto.CustomerLoginDto;
import org.TenderessLibertine.exceptions.AssociationExistsException;
import org.TenderessLibertine.exceptions.CustomerNotFoundException;
import org.TenderessLibertine.persistence.model.Customer;

import java.util.List;

public interface CustomerService {


    Customer save(Customer customer);

    void delete(Integer id) throws AssociationExistsException, CustomerNotFoundException, AssociationExistsException, CustomerNotFoundException;


    List<Customer> list();

    Customer get(Integer id);

    Customer customerValidation(CustomerLoginDto customerLoginDto);

}
