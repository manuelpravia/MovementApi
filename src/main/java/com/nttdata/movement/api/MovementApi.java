package com.nttdata.movement.api;

import com.nttdata.movement.domain.dto.CreateMovementRequest;
import com.nttdata.movement.domain.dto.MovementResponse;
import com.nttdata.movement.domain.dto.UpdateMovementRequest;
import com.nttdata.movement.domain.service.MovementService;
import com.nttdata.movement.infraestructure.data.document.Movement;
import com.nttdata.movement.util.mapper.MovementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/movements")
public class MovementApi {

    @Autowired
    private MovementService movementService;

    @Autowired
    private MovementMapper movementMapper;

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<MovementResponse> getMovements(){
        return movementService.getMovements().map(movementMapper::toMovementResponse);
    }

    @GetMapping("/{id}")
    public Mono<MovementResponse> getMovement(@PathVariable String id){
        return movementService.validateAndGetMovement(id).map(movementMapper::toMovementResponse);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<MovementResponse> createMovement(@Valid @RequestBody CreateMovementRequest createMovementRequest) {
        Movement movement = movementMapper.toMovement(createMovementRequest);
        return movementService.saveMovement(movement).map(movementMapper::toMovementResponse);
    }

    @PatchMapping("/{id}")
    public Mono<MovementResponse> updateMovement(@PathVariable String id,
                                                 @RequestBody UpdateMovementRequest updateMovementRequest) {
        return movementService.validateAndGetMovement(id)
                .doOnSuccess(movement -> {
                    movementMapper.updateMovementFromRequest(updateMovementRequest, movement);
                    movementService.saveMovement(movement).subscribe();
                })
                .map(movementMapper::toMovementResponse);
    }

    @DeleteMapping("/{id}")
    public Mono<MovementResponse> deleteMovement(@PathVariable String id) {
        return movementService.validateAndGetMovement(id)
                .doOnSuccess(customer -> movementService.deleteMovement(customer).subscribe())
                .map(movementMapper::toMovementResponse);
    }



}
