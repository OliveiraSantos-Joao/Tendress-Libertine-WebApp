package org.TenderessLibertine.persistence.dao.jpa;

import org.TenderessLibertine.persistence.dao.CustomerDao;
import org.TenderessLibertine.persistence.model.Customer;
import org.springframework.stereotype.Repository;


@Repository
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {


    public JpaCustomerDao() {
        super(Customer.class);
    }
}
