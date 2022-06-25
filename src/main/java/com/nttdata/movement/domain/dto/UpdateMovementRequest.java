package com.nttdata.movement.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateMovementRequest {

    private String idAccount;
    private String type;
    private BigDecimal amount;
}
