package pl.eiti.rso.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product {
    Long id;
    String productType;
    ProductCategory productCategory;
    String description;
    String productNo;
    BigDecimal productPrice;
    Boolean isInSpecialOffer;
    String name;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "PRODUCT_TYPE")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", referencedColumnName = "ID")
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "PRODUCT_NO")
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    @Column(name = "PRODUCT_PRICE")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Column(name = "IS_IN_SPECIAL_OFFERS")
    public Boolean getInSpecialOffer() {
        return isInSpecialOffer;
    }

    public void setInSpecialOffer(Boolean inSpecialOffer) {
        isInSpecialOffer = inSpecialOffer;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(Long id, String productType, ProductCategory productCategory, String description, String productNo, BigDecimal productPrice, Boolean isInSpecialOffer, String name) {
        this.id = id;
        this.productType = productType;
        this.productCategory = productCategory;
        this.description = description;
        this.productNo = productNo;
        this.productPrice = productPrice;
        this.isInSpecialOffer = isInSpecialOffer;
        this.name = name;
    }
}
