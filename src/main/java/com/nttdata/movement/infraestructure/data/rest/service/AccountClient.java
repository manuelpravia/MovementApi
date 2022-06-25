package com.nttdata.movement.infraestructure.data.rest.service;

import com.nttdata.movement.infraestructure.data.rest.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;


@FeignClient(name = "account-client")
//@RequestMapping("/api/accounts")
public interface AccountClient {

    @GetMapping("/api/accounts/{id}")
    public Mono<Account> getAccount(@PathVariable String id);
}
