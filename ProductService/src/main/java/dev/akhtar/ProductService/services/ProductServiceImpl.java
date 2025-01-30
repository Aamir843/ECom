package dev.akhtar.ProductService.services;

import dev.akhtar.ProductService.exceptions.NoSuchCategoryExistsException;
import dev.akhtar.ProductService.models.Category;
import dev.akhtar.ProductService.models.Product;
import dev.akhtar.ProductService.projections.ProductProjection;
import dev.akhtar.ProductService.repositories.CategoryRepository;
import dev.akhtar.ProductService.repositories.ProductRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service("realService")
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(long id) {

       Optional<Product> product= productRepository.findById(id);
       if(product.isPresent()){
           return product.get();
       }else {
            throw new ServiceException("ID does not exists");
       }
    }

    @Override
    public Product createProduct(String title, double price, String category, String description, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setImageUrl(image);
        product.setDescription(description);

        Optional<Category> category1 = categoryRepository.findByTitle(category);
        if(category1.isPresent()){
            product.setCategory(category1.get());
        }else{
            throw new NoSuchCategoryExistsException("No Such Category exists");
        }

        product.setCreatedDate(Instant.now());

        return productRepository.save(product);

    }

    @Override
    public List<Product> searchProduct(String keyword) {
        if(keyword== null){
            throw new ServiceException("Bad Request");
        }
        Optional<List<Product>> products = productRepository.searchByKeyword(keyword);

        if(products.isPresent() && !products.get().isEmpty()){
            return products.get();
        }else{
            throw new ServiceException("No products found ");
        }
    }

    @Override
    public List<ProductProjection> getTitleAndName(String categoryName) {
         return productRepository.findIdAndTitleWithGivenCategory(categoryName);
    }

}
