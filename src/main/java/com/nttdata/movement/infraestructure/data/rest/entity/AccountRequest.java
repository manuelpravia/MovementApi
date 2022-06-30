package com.nttdata.movement.infraestructure.data.rest.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AccountRequest {

    private String numAccount;
    private BigDecimal maintenance;
    private int maxMovement;
    private String type;
    private BigDecimal availableBalance;
    private List<String> customers;
}
