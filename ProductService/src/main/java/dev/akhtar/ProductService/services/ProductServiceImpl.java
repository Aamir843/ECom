package dev.akhtar.ProductService.services;

import dev.akhtar.ProductService.dtos.ProductDto;
import dev.akhtar.ProductService.models.Category;
import dev.akhtar.ProductService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        ProductDto[] productDtos = restTemplate.getForObject("https://fakestoreapi.com/products",ProductDto[].class);
        List<Product> products= new ArrayList<>();

        for(ProductDto productDtoss:productDtos){
            products.add(productDtoss.toProduct());
        }
        return products;
    }

    @Override
    public Product getSingleProduct(long id) {
        Optional<ProductDto> productDto = Optional.ofNullable(restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDto.class));

        return productDto.get().toProduct();

//        if(productDto.isPresent()){
//            return productDto.get().toProduct();
//        }else{
//            throw new ServerException("");
//        }
    }

    @Override
    public Product createProduct(String title, double price, String category, String description, String image) {

        ProductDto productDto = new ProductDto();
        productDto.setTitle(title);
        productDto.setPrice(price);
        productDto.setCategory(category);
        productDto.setDescription(description);
        productDto.setImage(image);

        productDto = restTemplate.postForObject("https://fakestoreapi.com/products",productDto, ProductDto.class);

        return productDto.toProduct();
    }

}
