package com.nttdata.bc19.mstransaction.exception;

public class ActProCreCarPerCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "ACTIVE PRODUCT CREDIT CARD PERSON CLIEN NOT FOUND";

    public ActProCreCarPerCliNotFoundException(){
        super(MESSAGE);
    }
}
