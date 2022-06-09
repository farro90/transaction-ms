package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreBusCli;
import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarBusCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCreBusCliRepository extends ReactiveMongoRepository<TransactionActProCreBusCli, String> {
    Flux<TransactionActProCreBusCli> findByIdActProCreBusCli(String idActProCreBusCli);
}
