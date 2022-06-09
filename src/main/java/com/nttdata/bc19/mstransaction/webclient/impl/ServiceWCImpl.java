package com.nttdata.bc19.mstransaction.webclient.impl;

import com.nttdata.bc19.mstransaction.exception.*;
import com.nttdata.bc19.mstransaction.model.responseWC.*;
import com.nttdata.bc19.mstransaction.webclient.IServiceWC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class ServiceWCImpl implements IServiceWC {

    private static final String URL_GATEWAY = "http://localhost:8080";
    private static final String URL_API_MANAGEMENT = "http://localhost:8085";

    @Autowired
    private WebClient.Builder webClient;

    @Override
    public Mono<PasProPerCli> findPasProPerCliById(String id) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().get().uri("/api/pasive/person/".concat(id))
                .retrieve()
                .bodyToMono(PasProPerCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProPerCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<PasProBusCli> findPasProBusCliById(String id) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().get().uri("/api/pasive/business/".concat(id))
                .retrieve()
                .bodyToMono(PasProBusCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProBusCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCrePerCli> findActProCrePerCliById(String id) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().get().uri("/api/active/credit/person/".concat(id))
                .retrieve()
                .bodyToMono(ActProCrePerCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ActProCrePerCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCreCarPerCli> findActProCreCarPerCliById(String id) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().get().uri("/api/active/credit-card/person/".concat(id))
                .retrieve()
                .bodyToMono(ActProCreCarPerCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ActProCreBusCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCreBusCli> findActProCreBusCliById(String id) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().get().uri("/api/active/credit/business/".concat(id))
                .retrieve()
                .bodyToMono(ActProCreBusCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ActProCreBusCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCreCarBusCli> findActProCreCarBusCliById(String id) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().get().uri("/api/active/credit-card/business/".concat(id))
                .retrieve()
                .bodyToMono(ActProCreCarBusCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new ActProCreCarBusCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<PasProPerCli> updatePasProPerCli(PasProPerCli pasProPerCli) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().put().uri("/api/pasive/person/")
                .body(Mono.just(pasProPerCli), PasProPerCli.class)
                .retrieve()
                .bodyToMono(PasProPerCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProPerCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<PasProBusCli> updatePasProBusCli(PasProBusCli pasProBusCli) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().put().uri("/api/pasive/business/")
                .body(Mono.just(pasProBusCli), PasProBusCli.class)
                .retrieve()
                .bodyToMono(PasProBusCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProBusCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCrePerCli> updateActProCrePerCli(ActProCrePerCli actProCrePerCli) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().put().uri("/api/active/credit/person/")
                .body(Mono.just(actProCrePerCli), ActProCrePerCli.class)
                .retrieve()
                .bodyToMono(ActProCrePerCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProPerCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCreBusCli> updateActProCreBusCli(ActProCreBusCli actProCreBusCli) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().put().uri("/api/active/credit/business/")
                .body(Mono.just(actProCreBusCli), ActProCreBusCli.class)
                .retrieve()
                .bodyToMono(ActProCreBusCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProBusCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCreCarPerCli> updateActProCreCarPerCli(ActProCreCarPerCli actProCreCarPerCli) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().put().uri("/api/active/credit-card/person/")
                .body(Mono.just(actProCreCarPerCli), ActProCrePerCli.class)
                .retrieve()
                .bodyToMono(ActProCreCarPerCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProPerCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }

    @Override
    public Mono<ActProCreCarBusCli> updateActProCreCarBusCli(ActProCreCarBusCli actProCreCarBusCli) {
        return webClient.baseUrl(URL_API_MANAGEMENT).build().put().uri("/api/active/credit-card/business/")
                .body(Mono.just(actProCreCarBusCli), ActProCreCarBusCli.class)
                .retrieve()
                .bodyToMono(ActProCreCarBusCli.class)
                .onErrorResume(error -> {
                    WebClientResponseException response = (WebClientResponseException) error;
                    if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new PasProBusCliNotFoundException());
                    }
                    return Mono.error(error);
                });
    }


}
