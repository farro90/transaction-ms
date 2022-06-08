package com.nttdata.bc19.mstransaction.model.responseWC;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PasiveProduct {
    private String id;
    private String name;
    private double maintenanceCommission;
    private double transactionCommission;
    private double minimumOpeningAmount;
    private int numLimitMovements;
    private int dayMovement;
    private boolean allowBusinessClient;
    private boolean allowPersonClient;
    private boolean needCreditCard;
}
