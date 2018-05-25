/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.eiti.rso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.eiti.rso.domain.entity.Order;
import pl.eiti.rso.domain.entity.Product;
import pl.eiti.rso.domain.entity.ProductCategory;
import pl.eiti.rso.domain.repositories.DiscountCodeRepository;
import pl.eiti.rso.domain.repositories.HibernateDaoImpl;
import pl.eiti.rso.domain.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final DiscountCodeRepository repository;
    private final ProductRepository productRepository;
    private HibernateDaoImpl hibernateDao;

    @Autowired
    public DatabaseLoader(DiscountCodeRepository repository, ProductRepository productRepository, HibernateDaoImpl hibernateDao) {
        this.productRepository = productRepository;
        this.repository = repository;
        this.hibernateDao = hibernateDao;
    }

    @Override
    public void run(String... strings) throws Exception {
//        ProductCategory productCategory = new ProductCategory(Long.valueOf(1), "PILS", "PILS");
//        ArrayList<Product> productArrayList = new ArrayList<Product>();
//        productArrayList.add(new Product(Long.valueOf(1), "BEER", productCategory, "Perla", "PER12", BigDecimal.valueOf(2.5), false, "Perla"));
//        productArrayList.add(new Product(Long.valueOf(2), "BEER", productCategory, "Lomza Chmielowa", "LCH8", BigDecimal.valueOf(2.7), false, "Lomza Chmielowa"));
//        productArrayList.add(new Product(Long.valueOf(3), "BEER", productCategory, "Pilsner", "PILS48", BigDecimal.valueOf(4.5), false, "Pilsner"));
//        productArrayList.add(new Product(Long.valueOf(4), "BEER", productCategory, "PIWO8", "PIWO8", BigDecimal.valueOf(3.9), false, "PIWO8"));
//        productArrayList.add(new Product(Long.valueOf(5), "BEER", productCategory, "PIWO9", "PIWO9", BigDecimal.valueOf(3.9), false, "PIWO9"));
//        productArrayList.add(new Product(Long.valueOf(6), "BEER", productCategory, "PIW10", "PIW10", BigDecimal.valueOf(3.9), false, "PIW10"));
//        productArrayList.add(new Product(Long.valueOf(7), "BEER", productCategory, "PIW11", "PIW11", BigDecimal.valueOf(3.9), false, "PIW11"));
//        productArrayList.add(new Product(Long.valueOf(8), "BEER", productCategory, "PIW12", "PIW12", BigDecimal.valueOf(3.9), false, "PIW12"));
//        productArrayList.add(new Product(Long.valueOf(9), "BEER", productCategory, "PIW13", "PIW13", BigDecimal.valueOf(3.9), false, "PIW13"));
//        for (Product product:productArrayList) {
//            productRepository.save(product);
//        }
        //		this.repository.save(new User(Long.valueOf(3),"Frodo", "Baggins", "ring bearer"));
    }
}