package com.nttdata.bc19.mstransaction.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/trasaction")
public class TransactionApi {

    @PostMapping
    public Mono<Void> AccountTransaction(){
        return null;
    }
/*
    @PostMapping
    public Mono<Void> CreditTransaction(){
        return null;
    }

    @PostMapping
    public Mono<Void> CreditCardTransaction(){
        return null;
    }

    @GetMapping("/{id}")
    public Flux<Void> CheckBalancePasivePerson(){
        return null;
    }

    @GetMapping("/{id}")
    public Flux<Void> CheckBalancePasiveBusiness(){
        return null;
    }

    @GetMapping("/{id}")
    public Flux<Void> CheckBalanceActivePerson(){
        return null;
    }

    @GetMapping("/{id}")
    public Flux<Void> CheckBalanceActiveBusiness(){
        return null;
    }*/
}
