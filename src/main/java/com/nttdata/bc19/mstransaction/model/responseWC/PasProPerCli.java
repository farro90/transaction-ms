package com.nttdata.bc19.mstransaction.model.responseWC;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class PasProPerCli extends BaseModel{

    //private String code;
    private double amount;
    private String accountNumber;
    private LocalDateTime openingDate;
    private String idPersonClient;
    private String idPasiveProduct;
    private PersonClient personClient;
    private PasiveProduct pasiveProduct;
    //private boolean state;

}
