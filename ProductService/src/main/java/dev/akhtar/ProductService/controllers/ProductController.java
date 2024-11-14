package dev.akhtar.ProductService.controllers;

import dev.akhtar.ProductService.dtos.CreateProductRequestDto;
import dev.akhtar.ProductService.models.Product;
import dev.akhtar.ProductService.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){
        return productService.getSingleProduct(id);
    }

    @PostMapping("products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getPrice(),createProductRequestDto.getCategory(),
                createProductRequestDto.getDescription(),createProductRequestDto.getImage());
    }
}
