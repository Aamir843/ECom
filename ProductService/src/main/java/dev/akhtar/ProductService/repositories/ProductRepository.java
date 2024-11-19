package dev.akhtar.ProductService.repositories;

import dev.akhtar.ProductService.models.Product;
import dev.akhtar.ProductService.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product product);

    Optional<Product> findById(Long id);


//    @Query(value = "SELECT * FROM product WHERE MATCH(description, price, title) AGAINST (:keyword IN BOOLEAN MODE)", nativeQuery = true)
//    List<Product> searchProducts(@Param("keyword") String keyword);

//    @Query(value = "CREATE TEMPORARY TABLE temp_product_search AS SELECT id, title, price,description CONCAT(title, ' ', price, ' ', description) AS combined_data; " +
//            "SELECT * FROM temp_product_search WHERE combined_data LIKE :keyword; " +
//            "DROP TEMPORARY TABLE IF EXISTS temp_product_search;",
//            nativeQuery = true)
//    Optional<List<Product>> searchByKeyword(@Param("keyword") String keyword);


    @Query(value = "SELECT * FROM product WHERE CONCAT(title, ' ', price, ' ', description) LIKE %:keyword%",
            nativeQuery = true)
    Optional<List<Product>> searchByKeyword(@Param("keyword") String keyword);


//    @Query(value = "SELECT * FROM product " +
//            "WHERE MATCH(title, description) AGAINST(:keyword IN NATURAL LANGUAGE MODE)",
//            nativeQuery = true)
//    Optional<List<Product>> searchByKeyword(@Param("keyword") String keyword);


    @Query(value = "SELECT p.id as id, p.title as title FROM product p join category c on p.category_fk = c.id where c.title = :categoryName ", nativeQuery = true)
    List<ProductProjection> findIdAndTitleWithGivenCategory(@Param("categoryName") String categoryName);

}
