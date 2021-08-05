package org.TenderessLibertine.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {

    public CustomerDto(int id, String nickName, int password, String email, int matchedWithId, int hotelId) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.matchedWithId = matchedWithId;
        this.hotelId = hotelId;
    }


    private int id;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private String nickName;

    @Email
    private String email;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 5, max = 64)
    private int password;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    private int hotelId;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getMatchedWithId() {
        return matchedWithId;
    }

    public void setMatchedWithId(int matchedWithId) {
        this.matchedWithId = matchedWithId;
    }

    private int matchedWithId; //-1 no one


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
