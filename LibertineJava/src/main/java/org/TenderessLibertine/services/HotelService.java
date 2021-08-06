package org.TenderessLibertine.services;
import org.TenderessLibertine.persistence.model.Hotel;
import org.springframework.stereotype.Service;
import java.util.List;


public interface HotelService {

    List<Hotel> list();

    Hotel get(Integer id);


}
