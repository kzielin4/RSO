package pl.eiti.rso.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {

    Long id;
    String country;
    String city;
    String street;
    String buildingNo;
    String flatNo;
    String postCode;

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    @Column(name = "BUILDING_NO")
    public String getBuildingNo() {
        return buildingNo;
    }

    @Column(name = "FLAT_NO")
    public String getFlatNo() {
        return flatNo;
    }

    @Column(name = "POST_CODE")
    public String getPostCode() {
        return postCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
