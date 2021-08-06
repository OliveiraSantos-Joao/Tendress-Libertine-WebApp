package org.TenderessLibertine.persistence.dao.jpa;

import org.TenderessLibertine.persistence.model.Date;
import org.springframework.stereotype.Repository;

@Repository
public class JpaDateDao extends GenericJpaDao<Date> implements DateDao {

    public JpaDateDao(){super(Date.class);}
}
