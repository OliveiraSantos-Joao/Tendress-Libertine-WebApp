package org.TenderessLibertine.services;

import org.TenderessLibertine.persistence.dao.jpa.HotelDao;
import org.TenderessLibertine.persistence.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelDao hotelDao;

    @Autowired
    public void setHotelDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public List<Hotel> list() {
        return hotelDao.findAll();
    }

    @Override
    public Hotel get(Integer id) {
        return hotelDao.findById(id);
    }

    @Override
    public Hotel getHotelByName(String hotelName) {
        List<Hotel> hotels = list();

        for (Hotel hotel : hotels){
            if(hotel.getHotelName().equals(hotelName)){
                return hotel;
            }
        }
        return null;
    }
}
