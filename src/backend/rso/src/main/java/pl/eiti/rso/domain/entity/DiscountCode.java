package pl.eiti.rso.domain.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DISCOUNT_CODE")
public class DiscountCode extends BaseEntity {

    Long id;
    Date dateFrom;
    Date dateTo;
    String code;

    public DiscountCode() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "DATE_FROM")
    public Date getDateFrom() {
        return dateFrom;
    }

    @Column(name = "DATE_TO")
    public Date getDateTo() {
        return dateTo;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
