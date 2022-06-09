package com.nttdata.bc19.mstransaction.service;

import com.nttdata.bc19.mstransaction.model.TransactionPasProBusCli;
import com.nttdata.bc19.mstransaction.model.TransactionPasProPerCli;
import com.nttdata.bc19.mstransaction.request.TransactionPasProBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionPasProBusCliService {

    Mono<TransactionPasProBusCli> create(TransactionPasProBusCliRequest transactionPasProBusCliRequest);
    Mono<TransactionPasProBusCli> update(TransactionPasProBusCli transactionPasProBusCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionPasProBusCli> findById(String id);
    Flux<TransactionPasProBusCli> findAll();

    Flux<TransactionPasProBusCli> findByIdPasProBusCli(String idPasProBusCli);
}
