package com.nttdata.bc19.mstransaction.api;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarBusCli;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreCarBusCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCreCarBusCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/active/credit-card/business")
public class TrasactionActProCreCarBusCliApi {

    @Autowired
    private ITransactionActProCreCarBusCliService transactionActProCreCarBusCliService;

    @PostMapping
    public Mono<TransactionActProCreCarBusCli> create(@RequestBody TransactionActProCreCarBusCliRequest transactionActProCreCarBusCliRequest){
        return transactionActProCreCarBusCliService.create(transactionActProCreCarBusCliRequest);
    }

    @PutMapping
    public Mono<TransactionActProCreCarBusCli> update(@RequestBody TransactionActProCreCarBusCli transactionActProCreCarBusCli){
        return transactionActProCreCarBusCliService.update(transactionActProCreCarBusCli);
    }

    @GetMapping
    public Flux<TransactionActProCreCarBusCli> findAll(){
        return transactionActProCreCarBusCliService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionActProCreCarBusCli> findById(@PathVariable String id){ return transactionActProCreCarBusCliService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionActProCreCarBusCliService.deleteById(id);
    }
}
