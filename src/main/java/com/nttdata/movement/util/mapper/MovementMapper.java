package com.nttdata.movement.util.mapper;

import com.nttdata.movement.domain.dto.CreateMovementRequest;
import com.nttdata.movement.domain.dto.MovementResponse;
import com.nttdata.movement.domain.dto.UpdateMovementRequest;
import com.nttdata.movement.infraestructure.data.document.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MovementMapper {

    @Mapping(target = "id",ignore = true)
    Movement toMovement(CreateMovementRequest createMovementRequest);

    MovementResponse toMovementResponse(Movement movement);

    @Mapping(target = "id", ignore = true)
    void updateMovementFromRequest(UpdateMovementRequest updateMovementRequest, @MappingTarget Movement movement);
}
