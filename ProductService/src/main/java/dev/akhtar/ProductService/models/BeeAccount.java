package dev.akhtar.ProductService.models;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Data
public class BeeAccount {
    @Id
    Long id;

    String accountNumber;

    BigDecimal balance;


}
