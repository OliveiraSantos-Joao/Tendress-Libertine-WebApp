package org.TenderessLibertine.converters;

import org.TenderessLibertine.dto.DateDto;
import org.TenderessLibertine.persistence.model.Date;
import org.springframework.stereotype.Component;

@Component
public class DateToDateDto extends AbstractConverter<Date, DateDto>{


    @Override
    public DateDto convert(Date date) {
        DateDto dateDto = new DateDto();
        dateDto.setIdCustomer1(date.getIdCustomer1());
        dateDto.setIdCustomer2(date.getIdCustomer2());
        dateDto.setHotelName(date.getHotelName());

        return dateDto;
    }
}
