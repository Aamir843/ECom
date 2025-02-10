package dev.akhtar.ProductService.services;


import dev.akhtar.ProductService.models.BeeProduct;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeeProductService {

    BeeProduct beeProduct1= BeeProduct.builder().id(1).name("Acer Laptop").category("Gaming").build();
    BeeProduct beeProduct2= BeeProduct.builder().id(2).name("Lenovo Laptop").category("Office").build();

    public List<BeeProduct> getBeeProducts(String name, String category){
        List<BeeProduct> products = List.of(beeProduct1,beeProduct2);


        if (name != null) {
            products = products.stream()
                    .filter(p -> p.getName().toLowerCase().ign(name))
                    .collect(Collectors.toList());
        }

        if (category != null) {
            products = products.stream()
                    .filter(p -> p.getCategory().contains(category))
                    .collect(Collectors.toList());
        }
        return products;
    }
}


Interface I1{

        }

Interace I2{

        }

        Class A implements I1, I2{

        }

