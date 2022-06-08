package com.nttdata.bc19.mstransaction.model.responseWC;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActProCreBusCli extends BaseModel{
    private BigDecimal amountGiven;
    private BigDecimal amountPaid;
    private BigDecimal interestRate;
    private String idBusinessClient;
    private String idActiveProduct;
    private BusinessClient businessClient;
    private ActiveProduct activeProduct;
}
