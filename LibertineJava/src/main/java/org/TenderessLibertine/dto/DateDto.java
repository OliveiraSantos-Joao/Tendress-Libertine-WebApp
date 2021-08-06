package org.TenderessLibertine.dto;

public class DateDto {

    private int id;
    private int idCustomer1;
    private int idCustomer2;
    private String hotelName;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
