package com.nttdata.bc19.mstransaction.service.impl;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarBusCli;
import com.nttdata.bc19.mstransaction.repository.ITransactionActProCreCarBusCliRepository;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreCarBusCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCreCarBusCliService;
import com.nttdata.bc19.mstransaction.util.TransactionTypeActPro;
import com.nttdata.bc19.mstransaction.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionActProCreCarBusCliServiceImpl implements ITransactionActProCreCarBusCliService {

    @Autowired
    ITransactionActProCreCarBusCliRepository transactionActProCreCarBusCliRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionActProCreCarBusCli> create(TransactionActProCreCarBusCliRequest transactionActProCreCarBusCliRequest) {
        return clientServiceWC.findActProCreCarBusCliById(transactionActProCreCarBusCliRequest.getIdActProCreCarBusCli())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(actProCreCarBusCliResponse -> {
                    TransactionActProCreCarBusCli transactionActProCreCarBusCli = new TransactionActProCreCarBusCli();
                    transactionActProCreCarBusCli.setId(new ObjectId().toString());
                    transactionActProCreCarBusCli.setIdActProCreCarBusCli(transactionActProCreCarBusCliRequest.getIdActProCreCarBusCli());
                    transactionActProCreCarBusCli.setTransactionTypeActPro(transactionActProCreCarBusCliRequest.getTransactionTypeActPro());
                    transactionActProCreCarBusCli.setTransactionDate(LocalDateTime.now());
                    transactionActProCreCarBusCli.setCreatedAt(LocalDateTime.now());
                    transactionActProCreCarBusCli.setAmount(transactionActProCreCarBusCliRequest.getAmount());
                    //transactionActProCreCarBusCli.setActProCreCarBusCli(ActProCreCarBusCliResponse);
                    //return transactionActProCreCarBusCliRepository.save(transactionActProCreCarBusCli);

                    if(transactionActProCreCarBusCli.getTransactionTypeActPro().equals(TransactionTypeActPro.PAGO.name())) {
                        actProCreCarBusCliResponse.setAmountConsumed(actProCreCarBusCliResponse.getAmountConsumed() - transactionActProCreCarBusCliRequest.getAmount());
                        return clientServiceWC.updateActProCreCarBusCli(actProCreCarBusCliResponse)
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(actProCreCarPerCliResponseUpdate -> {
                                    transactionActProCreCarBusCli.setActProCreCarBusCli(actProCreCarPerCliResponseUpdate);
                                    return transactionActProCreCarBusCliRepository.save(transactionActProCreCarBusCli);
                                });
                    }
                    else if(transactionActProCreCarBusCli.getTransactionTypeActPro().equals(TransactionTypeActPro.CONSUMO.name())){
                        actProCreCarBusCliResponse.setAmountConsumed(actProCreCarBusCliResponse.getAmountConsumed() + transactionActProCreCarBusCliRequest.getAmount());
                        return clientServiceWC.updateActProCreCarBusCli(actProCreCarBusCliResponse)
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(actProCreCarPerCliResponseUpdate -> {
                                    transactionActProCreCarBusCli.setActProCreCarBusCli(actProCreCarPerCliResponseUpdate);
                                    return transactionActProCreCarBusCliRepository.save(transactionActProCreCarBusCli);
                                });
                    }
                    return null;
                });
    }

    @Override
    public Mono<TransactionActProCreCarBusCli> update(TransactionActProCreCarBusCli transactionActProCreCarBusCli) {
        transactionActProCreCarBusCli.setUpdatedAt(LocalDateTime.now());
        return transactionActProCreCarBusCliRepository.save(transactionActProCreCarBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionActProCreCarBusCliRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionActProCreCarBusCli> findById(String id) {
        return transactionActProCreCarBusCliRepository.findById(id);
    }

    @Override
    public Flux<TransactionActProCreCarBusCli> findAll() {
        return transactionActProCreCarBusCliRepository.findAll();
    }

    @Override
    public Flux<TransactionActProCreCarBusCli> findByIdActProCreCarBusCli(String idActProCreCarBusCli) {
        return null;
    }
}
