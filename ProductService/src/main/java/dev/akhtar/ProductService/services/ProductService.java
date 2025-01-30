package dev.akhtar.ProductService.services;

import dev.akhtar.ProductService.models.Product;
import dev.akhtar.ProductService.projections.ProductProjection;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(String title, double price, String category,String description, String image);

    List<Product> searchProduct(String keyword);


    default List<ProductProjection> getTitleAndName(String categoryName){
        return null;
    }
}
