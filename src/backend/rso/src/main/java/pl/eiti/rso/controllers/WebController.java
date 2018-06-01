package pl.eiti.rso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.eiti.rso.domain.entity.Product;
import pl.eiti.rso.domain.entity.ProductCategory;
import pl.eiti.rso.domain.repositories.HibernateDaoImpl;
import pl.eiti.rso.domain.repositories.OrderRepository;
import pl.eiti.rso.domain.repositories.ProductCategoryRepository;
import pl.eiti.rso.domain.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @Autowired
    HibernateDaoImpl hibernateDao;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/addProducts", method = RequestMethod.GET)
    public void addProducts() {
        List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
        productCategories.add(new ProductCategory(Long.valueOf(1), "Przeniczne", "Rodzaj piw Przeczniczne"));
        productCategories.add(new ProductCategory(Long.valueOf(2), "Pils", "Rodzaj piw Pils"));
        productCategories.add(new ProductCategory(Long.valueOf(3), "Apa", "Rodzaj piw Apa"));
        productCategories.add(new ProductCategory(Long.valueOf(4), "Ipa", "Rodzaj piw Ipa"));
        List<Product> products = new ArrayList<Product>();
        hibernateDao.saveListAndFlush(productCategories);
        for (int i = 1; i < 40; i++) {
            products.add(new Product("Piwo", productCategories.get((int) Math.random() * (5)), "Opis piwa -" + i, String.valueOf(912321 * i), BigDecimal.valueOf(3 + Math.random() * (4)), false, "Piwo " + i));
        }
        hibernateDao.saveListAndFlush(products);
    }

    @RequestMapping(value = "/cleanDB", method = RequestMethod.GET)
    public void cleanAll() {
        productRepository.deleteAll();
        productCategoryRepository.deleteAll();
    }

    @RequestMapping("/createOrder")
    public void createOrder() {

    }

}
