package dev.akhtar.ProductService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends Base {

    private String title;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_fk")
    private Category category;
    private String description;
    private String imageUrl;
}
