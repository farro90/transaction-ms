package com.nttdata.bc19.mstransaction.service;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarBusCli;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreCarBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCreCarBusCliService {

    Mono<TransactionActProCreCarBusCli> create(TransactionActProCreCarBusCliRequest transactionActProCreCarBusCliRequest);
    Mono<TransactionActProCreCarBusCli> update(TransactionActProCreCarBusCli transactionActProCreCarBusCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCreCarBusCli> findById(String id);
    Flux<TransactionActProCreCarBusCli> findAll();
}
