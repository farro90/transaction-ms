package com.nttdata.bc19.mstransaction.exception;

public class PasProBusCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "PASIVE PRODUCT BUSINESS CLIEN NOT FOUND";

    public PasProBusCliNotFoundException(){
        super(MESSAGE);
    }
}
