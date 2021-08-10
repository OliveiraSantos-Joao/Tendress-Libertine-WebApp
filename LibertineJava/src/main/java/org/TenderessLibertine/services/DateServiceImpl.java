package org.TenderessLibertine.services;

import org.TenderessLibertine.exceptions.AssociationExistsException;
import org.TenderessLibertine.exceptions.CustomerNotFoundException;
import org.TenderessLibertine.persistence.dao.jpa.DateDao;
import org.TenderessLibertine.persistence.model.Customer;
import org.TenderessLibertine.persistence.model.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateServiceImpl implements DateService {

    private DateDao dateDao;

    @Autowired
    public void setDatesDao(DateDao dateDao) {
        this.dateDao = dateDao;
    }

    @Override
    public List<Date> list() {
        return dateDao.findAll();
    }

    @Override
    public Date get(Integer id) {
        return dateDao.findById(id);
    }

    @Override
    public Date save(Date date) {
        return dateDao.saveOrUpdate(date);
    }

    @Override
    public void delete(Integer id) throws AssociationExistsException, CustomerNotFoundException, AssociationExistsException, CustomerNotFoundException {
        dateDao.delete(id);
    }

    @Override
    public int getCustomer1ByDate(Integer id) {

        List<Date> dates = list();

        for (Date date : dates) {

            int customer1 = date.getIdCustomer1();
            int customer2 = date.getIdCustomer2();

            if (customer1 == id) {
                return id;
            }


        }
        return -1;

    }

    @Override
    public int getCustomer2ByDate(Integer id) {

        List<Date> dates = list();

        for (Date date : dates) {

            int customer2 = date.getIdCustomer2();

            if (customer2 == id) {
                return id;
            }

        }
        return -1;

    }

    @Override
    public String getHotelById(Integer id) {
        return null;
    }

    @Override
    public String getHotelByCustomerId(Integer id) {

        List<Date> dates = list();

        int customerId = -1;
        String hotelName = null;
        for (Date date : dates) {

            int customer1 = date.getIdCustomer1();
            int customer2 = date.getIdCustomer2();
            hotelName = date.getHotelName();

            if (customer1 == id) {
                customerId = id;
                break;
            }
            if (customer2 == id) {
                customerId = id;
                break;
            }

        }

        return hotelName;
    }

    @Override
    public Date getDateBtCustomer1(Integer id) {
        List<Date> dates = list();

        int customerId = -1;
        String hotelName = null;

        for (Date date : dates) {

            int customer1 = date.getIdCustomer1();
            int customer2 = date.getIdCustomer2();

            hotelName = date.getHotelName();

            if (customer1 == id) {
                return date;

            }
            if (customer2 == id) {
                return date;

            }

        }

        return null;

    }

    @Override
    public Date getDateByCustomerId(Integer id) {

        List<Date> dateList = list();

        for (Date date : dateList) {

            if (date.getIdCustomer1() == id || date.getIdCustomer2() == id) {
                return date;
            }

        }

        return null;
    }

}
