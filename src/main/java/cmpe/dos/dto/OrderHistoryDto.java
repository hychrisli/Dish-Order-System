package cmpe.dos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class OrderHistoryDto {

    @JsonInclude(value = NON_NULL)
    private List<DishHistDetailDto> dishHistDetail ;

    @JsonInclude(value = NON_NULL)
    @ApiModelProperty(required = true)
    private String receiverName;

    private Short branchId;
    
    private Float totalPrice;
    
    private Boolean isDeliver;
    
    @JsonInclude(value = NON_NULL)
    private String phone;

    @JsonInclude(value = NON_NULL)
    private String street;

    @JsonInclude(value = NON_NULL)
    private String city;

    @JsonInclude(value = NON_NULL)
    private String state;

    @JsonInclude(value = NON_NULL)
    private String zipcode;

    @JsonInclude(value = NON_NULL)
    @ApiModelProperty(required = true)
    private String cardNum;

    @JsonInclude(value = NON_NULL)
    private String cardType;

    @JsonInclude(value = NON_NULL)
    private String cardholderName;

    @JsonInclude(value = NON_NULL)
    private Date date;

    @JsonInclude(value = NON_NULL)
    private Integer orderID;

    @JsonInclude(value = NON_NULL)
    private String username;

    public OrderHistoryDto() {
        super();
    }

    public void setOrderId(Integer dishID) {
        this.orderID = dishID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getOrderID() { return orderID; }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<DishHistDetailDto> getDishHistDetail() {
        return dishHistDetail;
    }

    public void setDishHistDetail(List<DishHistDetailDto> dishHistDetail) {
        this.dishHistDetail = dishHistDetail;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Short getBranchId() {
        return branchId;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public Boolean getIsDeliver() {
        return isDeliver;
    }

    public void setBranchId(Short branchId) {
        this.branchId = branchId;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setIsDeliver(Boolean isDeliver) {
        this.isDeliver = isDeliver;
    }
}
