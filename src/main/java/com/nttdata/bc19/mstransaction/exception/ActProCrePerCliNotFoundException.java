package com.nttdata.bc19.mstransaction.exception;

public class ActProCrePerCliNotFoundException extends RuntimeException{
    private static final String MESSAGE = "ACTIVE PRODUCT CREDIT PERSON CLIEN NOT FOUND";

    public ActProCrePerCliNotFoundException(){
        super(MESSAGE);
    }
}
