package com.nttdata.bc19.mstransaction.service;

import com.nttdata.bc19.mstransaction.model.TransactionActProCrePerCli;
import com.nttdata.bc19.mstransaction.model.TransactionPasProBusCli;
import com.nttdata.bc19.mstransaction.request.TransactionActProCrePerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCrePerCliService {

    Mono<TransactionActProCrePerCli> create(TransactionActProCrePerCliRequest transactionActProCrePerCliRequest);
    Mono<TransactionActProCrePerCli> update(TransactionActProCrePerCli transactionActProCrePerCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCrePerCli> findById(String id);
    Flux<TransactionActProCrePerCli> findAll();

    Flux<TransactionActProCrePerCli> findByIdActProCrePerCli(String idActProCrePerCli);
}
