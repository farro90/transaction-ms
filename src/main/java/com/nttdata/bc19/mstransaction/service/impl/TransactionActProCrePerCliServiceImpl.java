package com.nttdata.bc19.mstransaction.service.impl;

import com.nttdata.bc19.mstransaction.model.TransactionActProCrePerCli;
import com.nttdata.bc19.mstransaction.repository.ITransactionActProCrePerCliRepository;
import com.nttdata.bc19.mstransaction.request.TransactionActProCrePerCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCrePerCliService;
import com.nttdata.bc19.mstransaction.util.TransactionTypeActPro;
import com.nttdata.bc19.mstransaction.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionActProCrePerCliServiceImpl implements ITransactionActProCrePerCliService {

    @Autowired
    ITransactionActProCrePerCliRepository transactionActProCrePerCliRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionActProCrePerCli> create(TransactionActProCrePerCliRequest transactionActProCrePerCliRequest) {
        return clientServiceWC.findActProCrePerCliById(transactionActProCrePerCliRequest.getIdActProCrePerCli())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(actProCrePerCliResponse -> {
                    TransactionActProCrePerCli transactionActProCrePerCli = new TransactionActProCrePerCli();
                    transactionActProCrePerCli.setId(new ObjectId().toString());
                    transactionActProCrePerCli.setIdActProCrePerCli(transactionActProCrePerCliRequest.getIdActProCrePerCli());
                    transactionActProCrePerCli.setTransactionTypeActPro(transactionActProCrePerCliRequest.getTransactionTypeActPro());
                    transactionActProCrePerCli.setTransactionDate(LocalDateTime.now());
                    transactionActProCrePerCli.setCreatedAt(LocalDateTime.now());
                    transactionActProCrePerCli.setAmount(transactionActProCrePerCliRequest.getAmount());
                    //transactionActProCrePerCli.setActProCrePerCli(actProCrePerCliResponse);
                    //return transactionActProCrePerCliRepository.save(transactionActProCrePerCli);

                    if(transactionActProCrePerCli.getTransactionTypeActPro().equals(TransactionTypeActPro.PAGO.name())) {
                        actProCrePerCliResponse.setAmountPaid(actProCrePerCliResponse.getAmountPaid() + transactionActProCrePerCliRequest.getAmount());
                        return clientServiceWC.updateActProCrePerCli(actProCrePerCliResponse)
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(actProCrePerCliResponseUpdate -> {
                                    transactionActProCrePerCli.setActProCrePerCli(actProCrePerCliResponseUpdate);
                                    return transactionActProCrePerCliRepository.save(transactionActProCrePerCli);
                                });
                    }
                    return null;
                });
    }

    @Override
    public Mono<TransactionActProCrePerCli> update(TransactionActProCrePerCli transactionActProCrePerCli) {
        transactionActProCrePerCli.setUpdatedAt(LocalDateTime.now());
        return transactionActProCrePerCliRepository.save(transactionActProCrePerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionActProCrePerCliRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionActProCrePerCli> findById(String id) {
        return transactionActProCrePerCliRepository.findById(id);
    }

    @Override
    public Flux<TransactionActProCrePerCli> findAll() {
        return transactionActProCrePerCliRepository.findAll();
    }

    @Override
    public Flux<TransactionActProCrePerCli> findByIdActProCrePerCli(String idActProCrePerCli) {
        return null;
    }
}
