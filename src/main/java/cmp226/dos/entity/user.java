package cmp226.dos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class user {

    @Id
    @Column(length = 20)
    private String username;
    
    @Column(length = 50, nullable = false)
    private String password;
    
    @Column(length = 12)
    private String phone;
    
    @Column(length = 100)
    private String address;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "signup_date")
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }
    
}
