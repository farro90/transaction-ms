package com.nttdata.bc19.mstransaction.model;

import com.nttdata.bc19.mstransaction.model.responseWC.ActProCreCarPerCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class TransactionActProCreCarPerCli extends BaseModel{
    //private  String code;
    private LocalDateTime transactionDate;
    private String idActProCreCarPerCli;
    private ActProCreCarPerCli actProCreCarPerCli;
    private String transactionTypeActPro;
    private double amount;
}
