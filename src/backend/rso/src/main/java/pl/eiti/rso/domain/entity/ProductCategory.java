package pl.eiti.rso.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {
    Long id;
    String name;
    String description;

    public ProductCategory() {
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

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
