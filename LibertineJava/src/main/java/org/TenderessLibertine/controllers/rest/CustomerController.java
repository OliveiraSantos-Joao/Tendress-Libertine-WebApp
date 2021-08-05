package org.TenderessLibertine.controllers.rest;


import org.TenderessLibertine.dto.CustomerDto;
import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    //public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {

        /*if (bindingResult.hasErrors() || customerDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/

        //Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));
        Customer savedCustomer = customerService.save(customer);

        // get help from the framework building the path for the newly created resource
        //UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + savedCustomer.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(uriComponents.toUri());

        //return new ResponseEntity<>(headers, HttpStatus.CREATED);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<Customer>> listCustomers() {

        //List<CustomerDto> customerDtos = customerService.list().stream()
        //        .map(customer -> customerToCustomerDto.convert(customer))
        //        .collect(Collectors.toList());

        List<Customer> customerDtos = customerService.list();

        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }
}
