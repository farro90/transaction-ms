package com.nttdata.bc19.mstransaction.repository;

import com.nttdata.bc19.mstransaction.model.TransactionActProCrePerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionActProCrePerCliRepository extends ReactiveMongoRepository<TransactionActProCrePerCli, String> {
}
