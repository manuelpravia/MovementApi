package com.nttdata.movement.infraestructure.data.repository;

import com.nttdata.movement.infraestructure.data.document.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovementRepository extends ReactiveMongoRepository<Movement,String> {
}
