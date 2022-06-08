package com.nttdata.bc19.mstransaction.model;

import com.nttdata.bc19.mstransaction.model.responseWC.ActProCreCarBusCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class TransactionActProCreCarBusCli extends BaseModel{
    //private  String code;
    private LocalDateTime transactionDate;
    private String idActProCreCarBusCli;
    private ActProCreCarBusCli actProCreCarBusCli;
    private String transactionTypeActPro;
    private BigDecimal amount;
}
