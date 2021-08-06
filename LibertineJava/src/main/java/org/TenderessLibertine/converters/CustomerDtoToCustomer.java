package org.TenderessLibertine.converters;


import org.TenderessLibertine.dto.CustomerDto;
import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CustomerDtoToCustomer implements Converter<CustomerDto, Customer> {

    private CustomerService customerService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer convert(CustomerDto customerDto) {

        Customer customer = (customerDto.getId() != null ? customerService.get(customerDto.getId()) : new Customer());

        customer.setNickName(customerDto.getNickName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());

        return customer;
    }
}
