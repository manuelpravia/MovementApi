package com.nttdata.movement.domain.service;

import com.nttdata.movement.exception.MovementNotFoudException;
import com.nttdata.movement.infraestructure.data.document.Movement;
import com.nttdata.movement.infraestructure.data.repository.MovementRepository;
import com.nttdata.movement.infraestructure.data.rest.entity.Account;
import com.nttdata.movement.infraestructure.data.rest.service.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements MovementService{

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountClient accountClient;

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
        //Account account = accountClient.getAccount(movement.getIdAccount());
        return movementRepository.save(movement);
    }

    @Override
    public Mono<Void> deleteMovement(Movement movement) {
        return movementRepository.delete(movement);
    }
}
