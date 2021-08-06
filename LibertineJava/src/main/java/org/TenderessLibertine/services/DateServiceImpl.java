package org.TenderessLibertine.services;

import org.TenderessLibertine.exceptions.AssociationExistsException;
import org.TenderessLibertine.exceptions.CustomerNotFoundException;
import org.TenderessLibertine.persistence.dao.jpa.DateDao;
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


}
