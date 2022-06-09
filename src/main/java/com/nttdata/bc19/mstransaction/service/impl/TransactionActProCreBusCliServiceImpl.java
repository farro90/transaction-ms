package com.nttdata.bc19.mstransaction.service.impl;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreBusCli;
import com.nttdata.bc19.mstransaction.repository.ITransactionActProCreBusCliRepository;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreBusCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCreBusCliService;
import com.nttdata.bc19.mstransaction.util.TransactionTypeActPro;
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
                .flatMap(actProCreBusCliResponse -> {
                    TransactionActProCreBusCli transactionActProCreBusCli = new TransactionActProCreBusCli();
                    transactionActProCreBusCli.setId(new ObjectId().toString());
                    transactionActProCreBusCli.setIdActProCreBusCli(transactionActProCreBusCliRequest.getIdActProCreBusCli());
                    transactionActProCreBusCli.setTransactionTypeActPro(transactionActProCreBusCliRequest.getTransactionTypeActPro());
                    transactionActProCreBusCli.setTransactionDate(LocalDateTime.now());
                    transactionActProCreBusCli.setCreatedAt(LocalDateTime.now());
                    transactionActProCreBusCli.setAmount(transactionActProCreBusCliRequest.getAmount());
                    //transactionActProCreBusCli.setActProCreBusCli(actProCreBusCliResponse);
                    //return transactionActProCreBusCliRepository.save(transactionActProCreBusCli);

                    if(transactionActProCreBusCli.getTransactionTypeActPro().equals(TransactionTypeActPro.PAGO.name())) {
                        actProCreBusCliResponse.setAmountPaid(actProCreBusCliResponse.getAmountPaid() + transactionActProCreBusCliRequest.getAmount());
                        return clientServiceWC.updateActProCreBusCli(actProCreBusCliResponse)
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(actProCreBusCliResponseUpdate -> {
                                    transactionActProCreBusCli.setActProCreBusCli(actProCreBusCliResponseUpdate);
                                    return transactionActProCreBusCliRepository.save(transactionActProCreBusCli);
                                });
                    }
                    return null;
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

    @Override
    public Flux<TransactionActProCreBusCli> findByIdActProCreBusCli(String idAActProCreBusCli) {
        return null;
    }
}
