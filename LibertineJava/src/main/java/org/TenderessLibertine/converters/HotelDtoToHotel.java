package org.TenderessLibertine.converters;


import org.TenderessLibertine.dto.HotelDto;
import org.TenderessLibertine.persistence.model.Hotel;
import org.TenderessLibertine.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelDtoToHotel implements Converter<HotelDto,Hotel> {

    private HotelService hotelService ;

    @Autowired
    public void setHotelServiceImpl(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @Override
    public Hotel convert(HotelDto hotelDto) {

        Hotel hotel = (hotelDto.getId() != null ? hotelService.get(hotelDto.getId()) : new Hotel());

        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setLatitude(hotelDto.getLatitude());
        hotel.setLongitude(hotelDto.getLongitude());

        return hotel;
    }
}
