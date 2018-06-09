package pl.eiti.rso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.eiti.rso.domain.entity.Product;
import pl.eiti.rso.domain.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findOne(id);
    }

}
