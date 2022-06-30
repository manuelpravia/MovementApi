package com.nttdata.movement.domain.service;

import com.nttdata.movement.exception.MovementNotFoudException;
import com.nttdata.movement.infraestructure.data.document.Movement;
import com.nttdata.movement.infraestructure.data.repository.MovementRepository;
import com.nttdata.movement.infraestructure.data.rest.entity.Account;
import com.nttdata.movement.infraestructure.data.rest.entity.AccountRequest;
import com.nttdata.movement.infraestructure.data.rest.service.AccountClient;
import com.nttdata.movement.util.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class MovementServiceImpl implements MovementService{

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Mono<Movement> validateAndGetMovement(String id) {
        return movementRepository.findById(id).switchIfEmpty(Mono.error(new MovementNotFoudException(id)));
    }

    @Override
    public Flux<Movement> getMovements() {
        return movementRepository.findAll();
    }

    @Override
    public Mono<Movement> saveMovement(Movement movement) {
        System.out.println("ID de la cienta: " +movement.getIdAccount());
        Account account = accountClient.getAccount(movement.getIdAccount());
       System.out.println("Maximo movimiento"+account.getMaxMovement());
        //System.out.println("id de accouent"+ account.getId());
      //  account.setAvailableBalance(account.getAvailableBalance().subtract(movement.getAmount()));
        //accountClient.updateAccount();
        return null;
        //return movementRepository.save(movement);
    }

    @Override
    public Mono<Void> deleteMovement(Movement movement) {
        return movementRepository.delete(movement);
    }
}
