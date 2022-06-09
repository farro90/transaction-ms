package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionPasProBusCli;
import com.nttdata.bc19.mstransaction.model.TransactionPasProPerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionPasProBusCliRepository extends ReactiveMongoRepository<TransactionPasProBusCli, String> {
    Flux<TransactionPasProBusCli> findByIdPasProBusCli(String idPasProBusCli);
}
