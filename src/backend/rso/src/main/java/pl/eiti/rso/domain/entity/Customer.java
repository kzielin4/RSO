package pl.eiti.rso.domain.entity;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class Customer implements Serializable {

    protected Address deliveryAddress;
    protected Address invoiceAddress;
    protected String phoneNo;
    protected String email;


    public Customer() {
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADDRESS_DELIVERY", referencedColumnName = "ID")
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
