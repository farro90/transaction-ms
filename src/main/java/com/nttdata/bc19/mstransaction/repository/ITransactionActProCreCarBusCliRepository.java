package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarBusCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionActProCreCarBusCliRepository extends ReactiveMongoRepository<TransactionActProCreCarBusCli, String> {
}
