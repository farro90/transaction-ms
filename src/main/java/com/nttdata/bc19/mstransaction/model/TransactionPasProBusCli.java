package com.nttdata.bc19.mstransaction.model;

import com.nttdata.bc19.mstransaction.model.responseWC.PasProBusCli;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class TransactionPasProBusCli extends BaseModel{
    //private  String code;
    private String idPasProBusCli;
    private PasProBusCli pasProBusCli;
    private LocalDateTime transactionDate;
    private String transactionTypePasPro;
    private BigDecimal amount;
}
