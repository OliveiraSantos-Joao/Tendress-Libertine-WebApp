package org.TenderessLibertine.persistence.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
@Table(name = "hotels")
public class Hotel extends AbstractModel {

    public Hotel() {
    }

    Double latitude;
    Double longitude;
    String hotelName;

    public String getLink2Pick() {
        return link2Pick;
    }

    String link2Pick;

    @Autowired
    public void setLink2Pick(String link2Pick) {
        this.link2Pick = link2Pick;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
