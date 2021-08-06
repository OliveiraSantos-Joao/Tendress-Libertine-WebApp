package org.TenderessLibertine.services;

import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.persistence.model.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomServiceImpl implements RandomService {


    private CustomerService customerService;
    private HotelService hotelService;
    private DateService dateService;
    private Random random = new Random();

    @Autowired
    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public void getRandomMatches() {

        List<Customer> customers;

        List<Date> dates;


        while (((customers = customerService.list()).size() / 2) > ((dates = dateService.list()).size())) {
            random1v1customerMatches(customers);
        }
    }

    private void random1v1customerMatches( List<Customer> customers) {

        int randCustomer1 = 1;
        int randCustomer2 = 1;

        while (randCustomer2 == randCustomer1) {
            randCustomer1 = random.nextInt(customers.size());
            randCustomer2 = random.nextInt(customers.size());
        }

        int randHotelId = random.nextInt(hotelService.list().size());
        String hotelName = hotelService.list().get(randHotelId).getHotelName();

        dateService.save(new Date(randCustomer1, randCustomer2, hotelName));


    }


}
