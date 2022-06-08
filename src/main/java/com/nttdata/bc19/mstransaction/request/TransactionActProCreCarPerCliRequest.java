package com.nttdata.bc19.mstransaction.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionActProCreCarPerCliRequest {
    private String idActProCreCarPerCli;
    private BigDecimal amount;
    private String transactionTypeActPro;
}
