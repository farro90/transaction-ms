package com.nttdata.bc19.mstransaction.service.impl;

import com.nttdata.bc19.mstransaction.model.TransactionPasProBusCli;
import com.nttdata.bc19.mstransaction.repository.ITransactionPasProBusCliRepository;
import com.nttdata.bc19.mstransaction.request.TransactionPasProBusCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionPasProBusCliService;
import com.nttdata.bc19.mstransaction.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionPasProBusCliServiceImpl implements ITransactionPasProBusCliService {

    @Autowired
    ITransactionPasProBusCliRepository transactionPasProBusCliRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionPasProBusCli> create(TransactionPasProBusCliRequest transactionPasProBusCliRequest) {
        return clientServiceWC.findPasProBusCliById(transactionPasProBusCliRequest.getIdPasProBusCli())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(PasProBusCliResponse -> {
                    TransactionPasProBusCli transactionPasProBusCli = new TransactionPasProBusCli();
                    transactionPasProBusCli.setId(new ObjectId().toString());
                    transactionPasProBusCli.setIdPasProBusCli(transactionPasProBusCliRequest.getIdPasProBusCli());
                    transactionPasProBusCli.setTransactionTypePasPro(transactionPasProBusCliRequest.getTransactionTypePasPro());
                    transactionPasProBusCli.setTransactionDate(LocalDateTime.now());
                    transactionPasProBusCli.setCreatedAt(LocalDateTime.now());
                    transactionPasProBusCli.setPasProBusCli(PasProBusCliResponse);

                    return transactionPasProBusCliRepository.save(transactionPasProBusCli);
                });
    }

    @Override
    public Mono<TransactionPasProBusCli> update(TransactionPasProBusCli transactionPasProBusCli) {
        transactionPasProBusCli.setUpdatedAt(LocalDateTime.now());
        return transactionPasProBusCliRepository.save(transactionPasProBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionPasProBusCliRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionPasProBusCli> findById(String id) {
        return transactionPasProBusCliRepository.findById(id);
    }

    @Override
    public Flux<TransactionPasProBusCli> findAll() {
        return transactionPasProBusCliRepository.findAll();
    }
}
