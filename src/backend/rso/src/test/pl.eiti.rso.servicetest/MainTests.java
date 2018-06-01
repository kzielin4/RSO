package pl.eiti.rso.servicetest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.eiti.rso.domain.entity.Product;
import pl.eiti.rso.domain.entity.ProductCategory;
import pl.eiti.rso.domain.repositories.HibernateDaoImpl;
import pl.eiti.rso.domain.repositories.OrderRepository;
import pl.eiti.rso.domain.repositories.ProductCategoryRepository;
import pl.eiti.rso.domain.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    HibernateDaoImpl hibernateDao;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    OrderRepository orderRepository;

    List<ProductCategory> productCategories;
    List<Product> products;

    @Before
    public void insertProducts() {
        System.out.println("----------------------Execute inserts-----------------------");
        productCategories = new ArrayList<ProductCategory>();
        productCategories.add(new ProductCategory(Long.valueOf(1), "Przeniczne", "Rodzaj piw Przeczniczne"));
        productCategories.add(new ProductCategory(Long.valueOf(2), "Pils", "Rodzaj piw Pils"));
        productCategories.add(new ProductCategory(Long.valueOf(3), "Apa", "Rodzaj piw Apa"));
        productCategories.add(new ProductCategory(Long.valueOf(4), "Ipa", "Rodzaj piw Ipa"));
        products = new ArrayList<Product>();
        hibernateDao.saveListAndFlush(productCategories);
        for (int i = 1; i < 40; i++) {
            //products.add(new Product("Piwo",productCategories.get((int)Math.random() * ( 5 )),"Opis piwa -"+i,String.valueOf(912321*i), BigDecimal.valueOf(3+Math.random() * ( 4 )),false,"Piwo "+i));
        }
        System.out.println("----------------------End inserts-----------------------");
        //productRepository.save(products);
        //hibernateDao.saveListAndFlush(products);
    }

    @Test
    public void test() {
        System.out.println("----------------------Execute tests-----------------------");
        hibernateDao.removeListAndFlush(productCategories);
        System.out.println("----------------------End tests-----------------------");

        //clean();

    }

    @Test
    public void display() {
        System.out.println("Koniec");
    }

    public void clean() {
        //hibernateDao.removeListAndFlush(products);
        //hibernateDao.removeListAndFlush(productCategories);
    }

    public HibernateDaoImpl getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDaoImpl hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
