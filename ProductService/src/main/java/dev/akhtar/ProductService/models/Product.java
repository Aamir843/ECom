package dev.akhtar.ProductService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Product {

    private int id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
}
