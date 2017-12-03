package cmpe.dos.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

public class WorkerDto {

    @JsonInclude(value = NON_NULL)
    @ApiModelProperty(required = true)
    private String username;
    
    @JsonInclude(value = NON_NULL)
    private String password;
    
    private String phone;

    private String street;
    
    private String city;
    
    private String state;
    
    private String zipcode;
    
    @JsonInclude(value = NON_NULL)
    private Short branchId;

    @JsonInclude(value = NON_NULL)
    private Date signupDate;
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
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

    public Short getBranchId() {
        return branchId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public void setBranchId(Short branchId) {
        this.branchId = branchId;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }
}
