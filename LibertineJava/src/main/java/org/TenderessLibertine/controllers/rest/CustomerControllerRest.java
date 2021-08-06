package org.TenderessLibertine.controllers.rest;


import org.TenderessLibertine.converters.*;
import org.TenderessLibertine.dto.CustomerDto;
import org.TenderessLibertine.dto.HotelDto;
import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.services.CustomerService;
import org.TenderessLibertine.services.DateService;
import org.TenderessLibertine.services.HotelService;
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
@RequestMapping("/api/customer")
public class CustomerControllerRest {

    private CustomerService customerService;
    private HotelService hotelService;
    private DateService dateService;

    private CustomerDtoToCustomer customerDtoToCustomer;
    private CustomerToCustomerDto customerToCustomerDto;

    private HotelDtoToHotel hotelDtoToHotel;
    private HotelToHotelDto hotelToHotelDto;

    private DateDtoToDate dateDtoToDate;
    private DateToDateDto dateToDateDto;

    @Autowired
    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @Autowired
    public void setHotelDtoToHotel(HotelDtoToHotel hotelDtoToHotel) {
        this.hotelDtoToHotel = hotelDtoToHotel;
    }
    @Autowired
    public void setHotelToHotelDto(HotelToHotelDto hotelToHotelDto) {
        this.hotelToHotelDto = hotelToHotelDto;
    }

    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDto customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setDateDtoToDate(DateDtoToDate dateDtoToDate) {
        this.dateDtoToDate = dateDtoToDate;
    }
    @Autowired
    public void setDateToDateDto(DateToDateDto dateToDateDto) {
        this.dateToDateDto = dateToDateDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || customerDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));


        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + savedCustomer.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
        //return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

   @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<CustomerDto>> listCustomers() {

        List<CustomerDto> customerDtos = customerService.list().stream()
                .map(customer -> customerToCustomerDto.convert(customer))
                .collect(Collectors.toList());



        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }


   @RequestMapping(method = RequestMethod.GET, path = {"/hotels"})
    public ResponseEntity<List<HotelDto>> listHotels() {

        List<HotelDto> hotelsDtos = hotelService.list().stream()
                .map(hotel -> hotelToHotelDto.convert(hotel))
                .collect(Collectors.toList());

        return new ResponseEntity<>(hotelsDtos, HttpStatus.OK);
    }
}