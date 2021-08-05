/*
package org.TenderessLibertine.services;

import org.TenderessLibertine.persistence.file2object.File2Object;
import org.TenderessLibertine.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Validations {


    private File2Object file2object;
    @Autowired
    public void setFile2object(File2Object file2object) {
        this.file2object = file2object;
    }


    public Customer isCustomerValid2Login(String email, int password) {

       ArrayList<Customer> customerArrayList = file2object.getCustomerArrayList();

       for(Customer customer : customerArrayList){

           if(customer.getPassword()==password && customer.getEmail().equals(email)){
               return customer;

           }
       }
       return null;

    }

    public boolean isNickNameValid(String nickname2Validate){

        if(nickname2Validate.length()>30 || nickname2Validate == null || nickname2Validate.equals("")){
            return false;

        }
        return true;

    }
    public boolean isEmailValid(String email2Validate){


        return true;

    }




}
*/
