package cmpe.dos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="USER")
public class User {

    @Id
    @Column(length = 20)
    private String username;
    
    @Column(length = 100, nullable = false)
    private String password;
    
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
    
    @Temporal(TemporalType.DATE)
    @Column(name = "SIGNUP_DATE", nullable = false)
    private Date signupDate;
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }
    
}
