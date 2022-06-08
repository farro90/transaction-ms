package com.nttdata.bc19.mstransaction.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionPasProBusCliRequest {
    private String idPasProBusCli;
    private BigDecimal amount;
    private String transactionTypePasPro;
}
