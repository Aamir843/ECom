package dev.akhtar.ProductService.services;

import dev.akhtar.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(String title, double price, String category,String description, String image);
}
