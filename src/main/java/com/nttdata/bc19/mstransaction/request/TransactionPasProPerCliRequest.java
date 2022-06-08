package com.nttdata.bc19.mstransaction.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionPasProPerCliRequest {
    private String idPasProPerCli;
    private double amount;
    private String transactionTypePasPro;
}
