package com.nttdata.bc19.mstransaction.service;

import com.nttdata.bc19.mstransaction.model.TransactionPasProPerCli;
import com.nttdata.bc19.mstransaction.request.TransactionPasProPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionPasProPerCliService {

    Mono<TransactionPasProPerCli> create(TransactionPasProPerCliRequest transactionPasProPerCliRequest);
    Mono<TransactionPasProPerCli> update(TransactionPasProPerCli transactionPasProPerCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionPasProPerCli> findById(String id);
    Flux<TransactionPasProPerCli> findAll();
}
