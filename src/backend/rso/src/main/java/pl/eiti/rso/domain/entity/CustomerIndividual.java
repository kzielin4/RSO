package pl.eiti.rso.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@DiscriminatorColumn(name = "CUSTOMER_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("INDIVIDUAL")
public class CustomerIndividual extends Customer {

    Long id;
    String firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
