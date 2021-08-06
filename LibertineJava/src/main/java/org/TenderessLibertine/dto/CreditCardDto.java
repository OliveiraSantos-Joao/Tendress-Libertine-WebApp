package org.TenderessLibertine.dto;

import javax.validation.constraints.*;
import java.util.Date;

public class CreditCardDto {

    public static final String cardRegex = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";

    @NotNull(message = "Card Number is mandatory")
    @NotBlank(message = "Card Number is mandatory")
    @Pattern(regexp = cardRegex, message = "Not a Valid Card")
    @Positive
    private String cardNumber;


    private String date;

    @Positive
    @NotNull
    @NotBlank
    @Max(3)
    @Min(3)
    private int cvv;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
