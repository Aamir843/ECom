package dev.akhtar.ProductService.controllers;

import dev.akhtar.ProductService.models.BeeAccount;
import dev.akhtar.ProductService.models.BeeProduct;
import dev.akhtar.ProductService.services.BeeBankService;
import dev.akhtar.ProductService.services.BeeProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeeProductController {

    private final BeeProductService beeProductService;

    private final BeeBankService beeBankService;

    public BeeProductController(BeeProductService beeProductService, BeeBankService beeBankService) {
        this.beeProductService = beeProductService;
        this.beeBankService = beeBankService;
    }

    @GetMapping("/products")
    public List<BeeProduct> getBeeProducts(@RequestParam String name, @RequestParam String category) {

        return beeProductService.getBeeProducts(name,category);
    }

    @GetMapping("/accounts/{id}")
    public BeeAccount getBeeProducts(@PathVariable Long id) throws Exception {
        return beeBankService.getAccountDetails(id);
    }



}
