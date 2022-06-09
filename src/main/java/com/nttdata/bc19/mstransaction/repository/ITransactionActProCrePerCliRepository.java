package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionActProCrePerCli;
import com.nttdata.bc19.mstransaction.model.TransactionPasProBusCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCrePerCliRepository extends ReactiveMongoRepository<TransactionActProCrePerCli, String> {
    Flux<TransactionActProCrePerCli> findByIdActProCrePerCli(String idActProCrePerCli);
}
