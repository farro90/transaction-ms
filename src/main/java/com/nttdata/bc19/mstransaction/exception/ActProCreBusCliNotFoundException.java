package com.nttdata.bc19.mstransaction.exception;

public class ActProCreBusCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "ACTIVE PRODUCT CREDIT BUSINESS CLIEN NOT FOUND";

    public ActProCreBusCliNotFoundException(){
        super(MESSAGE);
    }
}
