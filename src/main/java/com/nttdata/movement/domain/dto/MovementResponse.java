package com.nttdata.movement.domain.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class MovementResponse {

    private String id;
    private String idAccount;
    private String type;
    private BigDecimal amount;
}
