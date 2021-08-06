package org.TenderessLibertine.exceptions;


import org.TenderessLibertine.errors.ErrorMessage;

public class TransactionInvalidException extends Exception {


    public TransactionInvalidException() {
        super(ErrorMessage.TRANSACTION_INVALID);
    }
}
