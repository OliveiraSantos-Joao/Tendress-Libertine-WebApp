package org.TenderessLibertine.persistence.dao.jpa;



import org.TenderessLibertine.persistence.model.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public class JpaHotelDao extends GenericJpaDao<Hotel> implements HotelDao{

    public JpaHotelDao() {
        super(Hotel.class);
    }
}
