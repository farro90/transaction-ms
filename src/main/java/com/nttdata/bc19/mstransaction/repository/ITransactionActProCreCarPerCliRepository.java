package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarPerCli;
import com.nttdata.bc19.mstransaction.model.TransactionActProCrePerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCreCarPerCliRepository extends ReactiveMongoRepository<TransactionActProCreCarPerCli, String> {
    Flux<TransactionActProCreCarPerCli> findByIdActProCreCarPerCli(String idActProCreCarPerCli);
}
