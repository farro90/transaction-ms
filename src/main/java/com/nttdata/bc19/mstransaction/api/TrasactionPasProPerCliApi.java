package com.nttdata.bc19.mstransaction.api;

import com.nttdata.bc19.mstransaction.model.TransactionPasProPerCli;
import com.nttdata.bc19.mstransaction.request.TransactionPasProPerCliRequest;
import com.nttdata.bc19.mstransaction.service.ITransactionPasProPerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/pasive/person")
public class TrasactionPasProPerCliApi {

    @Autowired
    private ITransactionPasProPerCliService transactionPasProPerCliService;

    @PostMapping
    public Mono<TransactionPasProPerCli> create(@RequestBody TransactionPasProPerCliRequest transactionPasProPerCliRequest){
        return transactionPasProPerCliService.create(transactionPasProPerCliRequest);
    }

    @PutMapping
    public Mono<TransactionPasProPerCli> update(@RequestBody TransactionPasProPerCli transactionPasProPerCli){
        return transactionPasProPerCliService.update(transactionPasProPerCli);
    }

    @GetMapping
    public Flux<TransactionPasProPerCli> findAll(){
        return transactionPasProPerCliService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionPasProPerCli> findById(@PathVariable String id){ return transactionPasProPerCliService.findById(id); }

    @GetMapping("/find/{idPasProPerCli}")
    public Flux<TransactionPasProPerCli> findByIdPasProPerCli(@PathVariable String idPasProPerCli){
        return transactionPasProPerCliService.findByIdPasProPerCli(idPasProPerCli);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionPasProPerCliService.deleteById(id);
    }
}
