package org.TenderessLibertine.services;

import org.TenderessLibertine.exceptions.AssociationExistsException;
import org.TenderessLibertine.exceptions.CustomerNotFoundException;
import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.persistence.model.Date;

import java.util.List;

public interface DateService {

    List<Date> list();

    Date get(Integer id);

    Date save(Date date);

    void delete(Integer id) throws AssociationExistsException, CustomerNotFoundException, AssociationExistsException, CustomerNotFoundException;

    int getCustomer1ByDate(Integer id);

    int getCustomer2ByDate(Integer id);

    String getHotelById(Integer id);

    String getHotelByCustomerId(Integer id);

    Date getDateBtCustomer1(Integer id);

    Date getDateByCustomerId(Integer id);


}
