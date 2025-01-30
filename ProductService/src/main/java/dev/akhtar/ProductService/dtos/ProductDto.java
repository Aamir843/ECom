package dev.akhtar.ProductService.dtos;

import dev.akhtar.ProductService.models.Category;
import dev.akhtar.ProductService.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductDto implements Serializable {
    private double price;
    private String title;
    private String description;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();

        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category category1= new Category();
        category1.setTitle(category);
        product.setCategory(category1);

        return product;

    }

}
