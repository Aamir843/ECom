package dev.akhtar.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeeProduct {
    @Id
    int id;

    String name;
    String category;
    String price;
    int stockQty;

}
