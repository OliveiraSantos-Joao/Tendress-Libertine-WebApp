package org.TenderessLibertine.converters;

import org.TenderessLibertine.dto.DateDto;
import org.TenderessLibertine.persistence.model.Date;
import org.TenderessLibertine.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateDtoToDate implements Converter<DateDto, Date> {

    private DateService dateService;

    @Autowired
    public DateService getDateService() {
        return dateService;
    }

    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

    @Override
    public Date convert(DateDto dateDto) {
        Date date = (dateDto.getId() != null ? dateService.get(dateDto.getId()) : new Date());

        date.setIdCustomer1(dateDto.getIdCustomer1());
        date.setIdCustomer2(dateDto.getIdCustomer2());
        date.setHotelName(dateDto.getHotelName());

        return date;

    }
}
