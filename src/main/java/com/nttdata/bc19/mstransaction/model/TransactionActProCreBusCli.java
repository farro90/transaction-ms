package com.nttdata.bc19.mstransaction.model;

import com.nttdata.bc19.mstransaction.model.responseWC.ActProCreBusCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class TransactionActProCreBusCli extends BaseModel{
    //private  String code;
    private LocalDateTime transactionDate;
    private String idActProCreBusCli;
    private ActProCreBusCli actProCreBusCli;
    private String transactionTypeActPro;
    private BigDecimal amount;
}
