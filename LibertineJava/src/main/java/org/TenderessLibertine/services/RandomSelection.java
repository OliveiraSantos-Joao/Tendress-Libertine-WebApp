/*
package org.TenderessLibertine.services;

import org.TenderessLibertine.persistence.file2object.File2Object;
import org.TenderessLibertine.persistence.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class RandomSelection {




    private File2Object file2Object;

    @Autowired
    public void setFile2Object(File2Object file2Object) {
        this.file2Object = file2Object;
    }


    private final Random random = new Random();


    public void getRandomMatches() {

        ArrayList<Customer> freeCustomers;

        while ((freeCustomers = file2Object.getFreeCustomers()).size() > 1) {

            int randCustomer1 = 1;
            int randCustomer2 = 1;

            while (randCustomer2 == randCustomer1) {
                randCustomer1 = random.nextInt(freeCustomers.size());
                randCustomer2 = random.nextInt(freeCustomers.size());
            }
            freeCustomers.get(randCustomer1).setMatchedWithId(randCustomer2);
            freeCustomers.get(randCustomer2).setMatchedWithId(randCustomer1);

            int hotelId = getRandomHotelId();
            freeCustomers.get(randCustomer1).setHotelId(hotelId);
        }

    }

    private int getRandomHotelId() {

        return file2Object.gethotelsArray().get(random.nextInt(file2Object.gethotelsArray().size())).getId();
    }


}
*/
