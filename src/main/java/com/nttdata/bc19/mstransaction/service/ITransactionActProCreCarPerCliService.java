package com.nttdata.bc19.mstransaction.service;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarPerCli;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreCarPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCreCarPerCliService {

    Mono<TransactionActProCreCarPerCli> create(TransactionActProCreCarPerCliRequest transactionActProCreCarPerCliRequest);
    Mono<TransactionActProCreCarPerCli> update(TransactionActProCreCarPerCli transactionActProCreCarPerCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCreCarPerCli> findById(String id);
    Flux<TransactionActProCreCarPerCli> findAll();
}
