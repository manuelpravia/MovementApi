package com.nttdata.movement.domain.service;

import com.nttdata.movement.infraestructure.data.document.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {


    Mono<Movement> validateAndGetMovement(String id);

    Flux<Movement> getMovements();

    Mono<Movement> saveMovement(Movement movement);

    Mono<Void> deleteMovement(Movement movement);
}
