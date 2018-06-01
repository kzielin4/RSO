package pl.eiti.rso.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@DiscriminatorValue("BUSINESS")
public class CustomerBusiness extends Customer {

    Long id;
    String companyName;
    String nip;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "NIP")
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public CustomerBusiness(Long id, String companyName, String nip, String email) {
        this.id = id;
        this.companyName = companyName;
        this.nip = nip;
        this.email = email;
    }

    public CustomerBusiness(String companyName, String nip, String email) {
        this.companyName = companyName;
        this.nip = nip;
        this.email = email;
    }

    public CustomerBusiness() {
    }
}
