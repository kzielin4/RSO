package pl.eiti.rso.domain.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    Long id;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
