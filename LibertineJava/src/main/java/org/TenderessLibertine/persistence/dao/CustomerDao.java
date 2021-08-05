package org.TenderessLibertine.persistence.dao;

import org.TenderessLibertine.persistence.model.Customer;
import org.springframework.stereotype.Repository;

/**
 * Common interface for customer data access objects
 */
@Repository
public interface CustomerDao extends Dao<Customer> {
}
