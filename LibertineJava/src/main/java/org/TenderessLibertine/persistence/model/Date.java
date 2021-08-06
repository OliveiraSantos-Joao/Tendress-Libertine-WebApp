package org.TenderessLibertine.persistence.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dates")
public class Date extends AbstractModel {

    public Date() {
    }

    private int idCustomer1;
    private int idCustomer2;
    private String hotelName;


    public int getIdCustomer1() {
        return idCustomer1;
    }

    public void setIdCustomer1(int idCustomer1) {
        this.idCustomer1 = idCustomer1;
    }

    public int getIdCustomer2() {
        return idCustomer2;
    }

    public void setIdCustomer2(int idCustomer2) {
        this.idCustomer2 = idCustomer2;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
