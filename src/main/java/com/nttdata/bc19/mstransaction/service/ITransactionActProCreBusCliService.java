package com.nttdata.bc19.mstransaction.service;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreBusCli;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreBusCliRequest;
import com.nttdata.bc19.mstransaction.request.TransactionActProCrePerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCreBusCliService {

    Mono<TransactionActProCreBusCli> create(TransactionActProCreBusCliRequest transactionActProCreBusCliRequest);
    Mono<TransactionActProCreBusCli> update(TransactionActProCreBusCli transactionActProCreBusCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCreBusCli> findById(String id);
    Flux<TransactionActProCreBusCli> findAll();
}
