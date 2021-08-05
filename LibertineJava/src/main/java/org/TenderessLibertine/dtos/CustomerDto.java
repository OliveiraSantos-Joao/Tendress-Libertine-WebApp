package org.TenderessLibertine.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {

    int id;

    String localization;

    @NotNull(message = "Nickname is mandatory")
    @NotBlank(message = "Nickname is mandatory")
    @Size(min = 3, max = 64)
    String nickName;

    @Email
    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
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

