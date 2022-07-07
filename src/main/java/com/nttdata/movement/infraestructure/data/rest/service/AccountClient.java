package com.nttdata.movement.infraestructure.data.rest.service;


import com.nttdata.movement.infraestructure.data.rest.entity.Account;
import com.nttdata.movement.infraestructure.data.rest.entity.AccountRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Qualifier;
import reactor.core.publisher.Mono;


@Component
public class AccountClient {

 private final WebClient webClient;

 public AccountClient(@Qualifier("accountApiWebClient") WebClient webClient){
     this.webClient = webClient;
 }

 public Mono<Account> getAccount(String id){
     return webClient.get()
             .uri(uriBuilder -> uriBuilder.path("/accounts/{id}").build(id))
             .retrieve()
             .bodyToMono(Account.class);
 }
    public Mono<Account> updateAccount(String id, AccountRequest accountRequest){
        return webClient.put()
                .uri(uriBuilder -> uriBuilder.path("/accounts/{id}").build(id))
                .body(Mono.just(accountRequest),AccountRequest.class)
                .retrieve()
                .bodyToMono(Account.class);
    }

}
