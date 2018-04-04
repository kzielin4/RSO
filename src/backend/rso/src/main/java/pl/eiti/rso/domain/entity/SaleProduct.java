package pl.eiti.rso.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DELIVERY")
public class SaleProduct {
    Long id;
    Product product;
    BigDecimal saleProductPrice;

    public SaleProduct() {
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "DELIVERY_TYPE")
    public BigDecimal getSaleProductPrice() {
        return saleProductPrice;
    }

    public void setSaleProductPrice(BigDecimal saleProductPrice) {
        this.saleProductPrice = saleProductPrice;
    }
}
