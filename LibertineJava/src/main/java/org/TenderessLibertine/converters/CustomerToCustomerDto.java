package org.TenderessLibertine.converters;
import org.TenderessLibertine.dto.CustomerDto;
import org.TenderessLibertine.persistence.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerToCustomerDto extends AbstractConverter<Customer, CustomerDto> {


    @Override
    public CustomerDto convert(Customer customer) {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setNickName(customer.getNickName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());

        return customerDto;
    }
}
