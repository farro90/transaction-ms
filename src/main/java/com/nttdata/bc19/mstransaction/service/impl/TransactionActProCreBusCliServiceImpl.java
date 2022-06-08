package com.nttdata.bc19.mstransaction.service.impl;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreBusCli;
import com.nttdata.bc19.mstransaction.repository.ITransactionActProCreBusCliRepository;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreBusCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCreBusCliService;
import com.nttdata.bc19.mstransaction.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionActProCreBusCliServiceImpl implements ITransactionActProCreBusCliService {

    @Autowired
    ITransactionActProCreBusCliRepository transactionActProCreBusCliRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionActProCreBusCli> create(TransactionActProCreBusCliRequest transactionActProCreBusCliRequest) {
        return clientServiceWC.findActProCreBusCliById(transactionActProCreBusCliRequest.getIdActProCreBusCli())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(ActProCreBusCliResponse -> {
                    TransactionActProCreBusCli transactionActProCreBusCli = new TransactionActProCreBusCli();
                    transactionActProCreBusCli.setId(new ObjectId().toString());
                    transactionActProCreBusCli.setIdActProCreBusCli(transactionActProCreBusCliRequest.getIdActProCreBusCli());
                    transactionActProCreBusCli.setTransactionTypeActPro(transactionActProCreBusCliRequest.getTransactionTypeActPro());
                    transactionActProCreBusCli.setTransactionDate(LocalDateTime.now());
                    transactionActProCreBusCli.setCreatedAt(LocalDateTime.now());
                    transactionActProCreBusCli.setActProCreBusCli(ActProCreBusCliResponse);

                    return transactionActProCreBusCliRepository.save(transactionActProCreBusCli);
                });
    }

    @Override
    public Mono<TransactionActProCreBusCli> update(TransactionActProCreBusCli transactionActProCreBusCli) {
        transactionActProCreBusCli.setUpdatedAt(LocalDateTime.now());
        return transactionActProCreBusCliRepository.save(transactionActProCreBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionActProCreBusCliRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionActProCreBusCli> findById(String id) {
        return transactionActProCreBusCliRepository.findById(id);
    }

    @Override
    public Flux<TransactionActProCreBusCli> findAll() {
        return transactionActProCreBusCliRepository.findAll();
    }
}
