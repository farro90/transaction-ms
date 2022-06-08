package com.nttdata.bc19.mstransaction.api;

import com.nttdata.bc19.mstransaction.model.TransactionActProCrePerCli;
import com.nttdata.bc19.mstransaction.request.TransactionActProCrePerCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCrePerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/active/credit/person")
public class TrasactionActProCrePerCliApi {

    @Autowired
    private ITransactionActProCrePerCliService transactionActProCrePerCliService;

    @PostMapping
    public Mono<TransactionActProCrePerCli> create(@RequestBody TransactionActProCrePerCliRequest transactionActProCrePerCliRequest){
        return transactionActProCrePerCliService.create(transactionActProCrePerCliRequest);
    }

    @PutMapping
    public Mono<TransactionActProCrePerCli> update(@RequestBody TransactionActProCrePerCli transactionActProCrePerCli){
        return transactionActProCrePerCliService.update(transactionActProCrePerCli);
    }

    @GetMapping
    public Flux<TransactionActProCrePerCli> findAll(){
        return transactionActProCrePerCliService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionActProCrePerCli> findById(@PathVariable String id){ return transactionActProCrePerCliService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionActProCrePerCliService.deleteById(id);
    }
}
