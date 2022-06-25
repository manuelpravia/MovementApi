package com.nttdata.movement.infraestructure.data.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movements")
public class Movement {
    @Id
    private String id;
    private String idAccount;
    private String type;
    private BigDecimal amount;
    @LastModifiedDate
    private LocalDateTime date;
}
