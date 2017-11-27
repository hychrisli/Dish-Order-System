package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="BRANCH")
public class Branch {

    @Id
    @Column(name = "BRANCH_ID")
    private int branchId;
    
    @Column(length = 12)
    private String phone;
    
    @Column(length = 50)
    private String street;
    
    @Column(length = 20)
    private String city;
    
    @Column(length = 20)
    private String state;
    
    @Column(length = 5)
    private String zipcode;
    
    @Column(length = 20)
    private String name;
    

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
    
}
