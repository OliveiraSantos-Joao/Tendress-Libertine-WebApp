package org.TenderessLibertine.persistence.model;

import javax.persistence.*;


@Entity
@Table(name = "customers")
public class Customer extends AbstractModel {

    public Customer() {}

    @Column(name = "nickname")
    private String nickName;
    private String email;
    private int password;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
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
