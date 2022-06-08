package com.nttdata.bc19.mstransaction.webclient.impl;

import com.nttdata.bc19.mstransaction.model.responseWC.*;
import com.nttdata.bc19.mstransaction.webclient.IServiceWC;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ServiceWCImpl implements IServiceWC {

    @Override
    public Mono<PasProPerCli> findPasProPerCliById(String id) {
        return null;
    }

    @Override
    public Mono<PasProBusCli> findPasProBusCliById(String id) {
        return null;
    }

    @Override
    public Mono<ActProCrePerCli> findActProCrePerCliById(String id) {
        return null;
    }

    @Override
    public Mono<ActProCreCarPerCli> findActProCreCarPerCliById(String id) {
        return null;
    }

    @Override
    public Mono<ActProCreBusCli> findActProCreBusCliById(String id) {
        return null;
    }

    @Override
    public Mono<ActProCreCarBusCli> findActProCreCarBusCliById(String id) {
        return null;
    }
}
