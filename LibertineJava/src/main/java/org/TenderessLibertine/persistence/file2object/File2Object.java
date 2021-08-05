/*
package org.TenderessLibertine.persistence.file2object;

import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.persistence.model.Hotel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;


@Service
public class File2Object {

    public void saveNewUser(String nickname, int pass, String email) {

        int id = getNextCustomerId();

        BufferedWriter bufferWriter;

        {
            try {
                bufferWriter = new BufferedWriter(new FileWriter("/Users/codecadet/Desktop/Hecaton/tenderesslibertine/LibertineJava/src/main/resources/customers.txt", true));

                String nameAndPass = id + ":" + nickname + ":" + pass + ":" + email + ":-1" + "-1";
                bufferWriter.write(nameAndPass, 0, nameAndPass.length());
                bufferWriter.newLine();

                bufferWriter.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Customer> getFreeCustomers() {

        try {

            BufferedReader bufferIn = new BufferedReader(new FileReader("/Users/codecadet/Desktop/Hecaton/tenderesslibertine/LibertineJava/src/main/resources/customers.txt"));
            String line;
            ArrayList<Customer> freeCustomers = new ArrayList<>();

            while ((line = bufferIn.readLine()) != null) {

                String[] customerInfo = line.split(":");

                if (Integer.parseInt(customerInfo[4]) != -1) {
                    freeCustomers.add(new Customer(Integer.parseInt(customerInfo[0]), customerInfo[1], Integer.parseInt(customerInfo[2]), customerInfo[3], Integer.parseInt(customerInfo[4]),-1));
                }
            }
            bufferIn.close();
            return freeCustomers;


        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return null;

    }

    public ArrayList<Hotel> gethotelsArray() {

        try {

            BufferedReader bufferIn = new BufferedReader(new FileReader("/Users/codecadet/Desktop/Hecaton/tenderesslibertine/LibertineJava/src/main/resources/hotels.txt"));
            String line;
            ArrayList<Hotel> hotels = new ArrayList<>();

            while ((line = bufferIn.readLine()) != null) {

                String[] hotelInfo = line.split(":");
                hotels.add(new Hotel(Integer.parseInt(hotelInfo[0]), hotelInfo[1], Integer.parseInt(hotelInfo[2]), Integer.parseInt(hotelInfo[3])));

            }
            bufferIn.close();
            return hotels;

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return null;
    }

   */
/* private Customer getCustomer(int pass, String email) {

        try {

            BufferedReader bufferIn = new BufferedReader(new FileReader("/Users/codecadet/Desktop/Hecaton/tenderesslibertine/LibertineJava/src/main/resources/customers.txt"));
            String userId;

            while ((userId = bufferIn.readLine()) != null) {

                String[] customerInfo = userId.split(":");


                if (customerInfo[3].equals(email) && Integer.parseInt(customerInfo[2]) == (pass)) {

                    bufferIn.close();
                    return new Customer(Integer.parseInt(customerInfo[0]), customerInfo[1], Integer.parseInt(customerInfo[2]), customerInfo[3], -1,-1);
                }
            }

            bufferIn.close();

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return null;
    }*//*


    private int getNextCustomerId() {
        try {
            if (getCustomerArrayList().get(0) != null) {
                return getCustomerArrayList().size();

            }
        } catch (IndexOutOfBoundsException e) {

        }

        return 0;
    }

    public ArrayList<Customer> getCustomerArrayList() {

        try {

            BufferedReader bufferIn = new BufferedReader(new FileReader("/Users/codecadet/Desktop/Hecaton/tenderesslibertine/LibertineJava/src/main/resources/customers.txt"));
            String line;
            ArrayList<Customer> customersArray = new ArrayList<>();

            while ((line = bufferIn.readLine()) != null) {

                String[] customerInfo = line.split(":");
                customersArray.add(new Customer(Integer.parseInt(customerInfo[0]), customerInfo[1], Integer.parseInt(customerInfo[2]), customerInfo[3], Integer.parseInt(customerInfo[4]), Integer.parseInt(customerInfo[5])));

            }
            bufferIn.close();
            return customersArray;


        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        return null;

    }



}
*/
