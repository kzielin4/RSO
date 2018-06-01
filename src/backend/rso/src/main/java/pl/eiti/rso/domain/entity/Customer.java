package pl.eiti.rso.domain.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "CUSTOMER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CUSTOMER_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Customer extends BaseEntity implements Serializable {

    Long id;
    protected Address deliveryAddress;
    protected Address invoiceAddress;
    protected String phoneNo;
    protected String email;


    public Customer() {
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ADDRESS_DELIVERY", referencedColumnName = "ID")
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ADDRESS_INVOICE", referencedColumnName = "ID")
    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    @Column(name = "PHONE_NUMBER")
    public String getPhoneNo() {
        return phoneNo;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
