package com.nttdata.movement.infraestructure.data.rest.service;

import com.nttdata.movement.infraestructure.data.rest.entity.Account;
import com.nttdata.movement.infraestructure.data.rest.entity.AccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@FeignClient(name = "account-client",url = "http://localhost:8082")
public interface AccountClient {

    @GetMapping("/accounts/{id}")
    Account getAccount(@PathVariable("id") String id);

    @PutMapping("/accounts/{id}")
     Account updateAccount(@PathVariable("id") String id,@RequestBody AccountRequest accountRequest);
}
