package com.nttdata.bc19.mstransaction.service.impl;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarPerCli;
import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarPerCli;
import com.nttdata.bc19.mstransaction.repository.ITransactionActProCreCarPerCliRepository;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreCarPerCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCreCarPerCliService;
import com.nttdata.bc19.mstransaction.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionActProCreCarPerCliServiceImpl implements ITransactionActProCreCarPerCliService {

    @Autowired
    ITransactionActProCreCarPerCliRepository transactionActProCreCarPerCliRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionActProCreCarPerCli> create(TransactionActProCreCarPerCliRequest transactionActProCreCarPerCliRequest) {
        return clientServiceWC.findActProCreCarPerCliById(transactionActProCreCarPerCliRequest.getIdActProCreCarPerCli())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(ActProCreCarPerCliResponse -> {
                    TransactionActProCreCarPerCli transactionActProCreCarPerCli = new TransactionActProCreCarPerCli();
                    transactionActProCreCarPerCli.setId(new ObjectId().toString());
                    transactionActProCreCarPerCli.setIdActProCreCarPerCli(transactionActProCreCarPerCliRequest.getIdActProCreCarPerCli());
                    transactionActProCreCarPerCli.setTransactionTypeActPro(transactionActProCreCarPerCliRequest.getTransactionTypeActPro());
                    transactionActProCreCarPerCli.setTransactionDate(LocalDateTime.now());
                    transactionActProCreCarPerCli.setCreatedAt(LocalDateTime.now());
                    transactionActProCreCarPerCli.setActProCreCarPerCli(ActProCreCarPerCliResponse);

                    return transactionActProCreCarPerCliRepository.save(transactionActProCreCarPerCli);
                });
    }

    @Override
    public Mono<TransactionActProCreCarPerCli> update(TransactionActProCreCarPerCli transactionActProCreCarPerCli) {
        transactionActProCreCarPerCli.setUpdatedAt(LocalDateTime.now());
        return transactionActProCreCarPerCliRepository.save(transactionActProCreCarPerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionActProCreCarPerCliRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionActProCreCarPerCli> findById(String id) {
        return transactionActProCreCarPerCliRepository.findById(id);
    }

    @Override
    public Flux<TransactionActProCreCarPerCli> findAll() {
        return transactionActProCreCarPerCliRepository.findAll();
    }
}
