package com.nttdata.bc19.mstransaction.request;

import com.nttdata.bc19.mstransaction.model.responseWC.ActProCrePerCli;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionActProCrePerCliRequest {
    private String idActProCrePerCli;
    private double amount;
    private String transactionTypeActPro;
}
