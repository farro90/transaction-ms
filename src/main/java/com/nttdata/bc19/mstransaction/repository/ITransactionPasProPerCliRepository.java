package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionPasProPerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionPasProPerCliRepository extends ReactiveMongoRepository<TransactionPasProPerCli, String> {

    Flux<TransactionPasProPerCli> findByIdPasProPerCli(String idPasProPerCli);
}
