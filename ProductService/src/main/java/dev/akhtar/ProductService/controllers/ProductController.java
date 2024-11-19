package dev.akhtar.ProductService.controllers;

import dev.akhtar.ProductService.dtos.CreateProductRequestDto;
import dev.akhtar.ProductService.exceptions.NoSuchCategoryExistsException;
import dev.akhtar.ProductService.models.Product;
import dev.akhtar.ProductService.projections.ProductProjection;
import dev.akhtar.ProductService.services.ProductService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("realService") ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping("products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getPrice(),createProductRequestDto.getCategory(),
                createProductRequestDto.getDescription(),createProductRequestDto.getImage()));
    }

    @GetMapping("products/search/{keyword}")
    public ResponseEntity<List<Product>> searchProductByKeyword(@PathVariable("keyword") String keyword){
        return ResponseEntity.ok().body(productService.searchProduct(keyword));
    }

    @GetMapping("products/searchBy/{categoryName}")
    public ResponseEntity<List<ProductProjection>> getTitleAndIdByCategory(@PathVariable("categoryName") String categoryName){
        return ResponseEntity.ok().body(productService.getTitleAndName(categoryName));
    }
}
