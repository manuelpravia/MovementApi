package com.nttdata.movement.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreateMovementRequest {

    @NotBlank
    private String idAccount;

    @NotBlank
    private String type;

    @NotNull
    private BigDecimal amount;
}
