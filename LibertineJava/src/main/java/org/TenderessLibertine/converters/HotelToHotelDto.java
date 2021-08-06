package org.TenderessLibertine.converters;

import org.TenderessLibertine.dto.HotelDto;
import org.TenderessLibertine.persistence.model.Hotel;
import org.TenderessLibertine.services.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelToHotelDto extends AbstractConverter<Hotel, HotelDto>{

    private HotelServiceImpl hotelServiceImpl ;

    @Autowired
    public void setHotelServiceImpl(HotelServiceImpl hotelServiceImpl) {
        this.hotelServiceImpl = hotelServiceImpl;
    }


    @Override
    public HotelDto convert(Hotel hotel) {

        HotelDto hotelDto = new HotelDto();

        hotelDto.setId(hotel.getId());
        hotelDto.setHotelName(hotel.getHotelName());
        hotelDto.setLatitude(hotel.getLatitude());
        hotelDto.setLongitude(hotel.getLongitude());

        return hotelDto;
    }
}
