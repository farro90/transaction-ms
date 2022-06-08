package com.nttdata.bc19.mstransaction.model.responseWC;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class ActProCrePerCli extends BaseModel{
    private double amountGiven;
    private double amountPaid;
    private double interestRate;
    private String idPersonClient;
    private String idActiveProduct;
    private PersonClient personClient;
    private ActiveProduct activeProduct;
}
