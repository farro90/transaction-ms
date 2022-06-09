package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarBusCli;
import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarPerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCreCarBusCliRepository extends ReactiveMongoRepository<TransactionActProCreCarBusCli, String> {
    Flux<TransactionActProCreCarBusCli> findByIdActProCreCarBusCli(String idActProCreCarBusCli);
}
