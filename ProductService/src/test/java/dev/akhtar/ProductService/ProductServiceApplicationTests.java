//package dev.akhtar.ProductService;
//
//import dev.akhtar.ProductService.models.Category;
//import dev.akhtar.ProductService.models.Product;
//import dev.akhtar.ProductService.repositories.CategoryRepository;
//import org.hibernate.Hibernate;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//class ProductServiceApplicationTests {
//
//	@Autowired
//	private CategoryRepository categoryRepository;
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void getAllCategories(){
//		List<Category> categoryList = categoryRepository.findAll();
//		System.out.println();
//	}
//
//	@Test
//	void getCategoriesById(){
//		Optional<Category> category = categoryRepository.findById(1L);
////		Hibernate.initialize(category.get().getProduct());
//		List<Product> products =category.get().getProduct();
////		System.out.println(products);
//	}
//
//
//}
