package pl.eiti.rso.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity {
    Long id;
    String deliveryType;
    String description;
    BigDecimal deliveryPrice;
    Long deliveryDay;

    public Delivery() {
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

    @Column(name = "DELIVERY_TYPE")
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "DELIVERY_PRICE")
    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Column(name = "DELIVERY_DAYS")
    public Long getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(Long deliveryDay) {
        this.deliveryDay = deliveryDay;
    }
}
