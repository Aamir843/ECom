package dev.akhtar.ProductService.services;

import dev.akhtar.ProductService.dtos.ProductDto;
import dev.akhtar.ProductService.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("fakeService")
@Primary
public class FakeStoreProductServiceImpl implements ProductService{

    private final RestTemplate restTemplate;

    private final RedisTemplate redisTemplate;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate, RedisTemplate redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
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
        // Step 1: Check the cache
        ProductDto cachedProductDto = (ProductDto) redisTemplate.opsForHash().get("Products", "product_" + id);
        if (cachedProductDto != null) {
            // Cache hit - Return the cached product
            return cachedProductDto.toProduct();
        }

        // Step 2: Cache miss - Fetch from external API
        ProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDto.class);
        if (productDto == null) {
            throw new RuntimeException("Product not found");
        }

        // Step 3: Save to cache
        redisTemplate.opsForHash().put("Products", "product_" + id, productDto);

        // Step 4: Return the product
        return productDto.toProduct();

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

    @Override
    public List<Product> searchProduct(String keyword) {
        return null;
    }

}
