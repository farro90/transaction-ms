package com.nttdata.bc19.mstransaction.exception;

public class ActProCreCarBusCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "ACTIVE PRODUCT CREDIT CARD BUSINESS CLIEN NOT FOUND";

    public ActProCreCarBusCliNotFoundException(){
        super(MESSAGE);
    }
}
