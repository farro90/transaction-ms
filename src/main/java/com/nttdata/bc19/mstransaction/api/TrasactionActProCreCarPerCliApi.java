package com.nttdata.bc19.mstransaction.api;

import com.nttdata.bc19.mstransaction.model.TransactionActProCreCarPerCli;
import com.nttdata.bc19.mstransaction.model.TransactionActProCrePerCli;
import com.nttdata.bc19.mstransaction.request.TransactionActProCreCarPerCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionActProCreCarPerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/active/credit-card/person")
public class TrasactionActProCreCarPerCliApi {

    @Autowired
    private ITransactionActProCreCarPerCliService transactionActProCreCarPerCliService;

    @PostMapping
    public Mono<TransactionActProCreCarPerCli> create(@RequestBody TransactionActProCreCarPerCliRequest transactionActProCreCarPerCliRequest){
        return transactionActProCreCarPerCliService.create(transactionActProCreCarPerCliRequest);
    }

    @PutMapping
    public Mono<TransactionActProCreCarPerCli> update(@RequestBody TransactionActProCreCarPerCli transactionActProCreCarPerCli){
        return transactionActProCreCarPerCliService.update(transactionActProCreCarPerCli);
    }

    @GetMapping
    public Flux<TransactionActProCreCarPerCli> findAll(){
        return transactionActProCreCarPerCliService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionActProCreCarPerCli> findById(@PathVariable String id){ return transactionActProCreCarPerCliService.findById(id); }

    @GetMapping("/find/{idActProCreCarPerCli}")
    public Flux<TransactionActProCreCarPerCli> findByIdActProCreCarPerCli(@PathVariable String idActProCreCarPerCli){
        return transactionActProCreCarPerCliService.findByIdActProCreCarPerCli(idActProCreCarPerCli);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionActProCreCarPerCliService.deleteById(id);
    }
}
