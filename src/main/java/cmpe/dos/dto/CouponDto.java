package cmpe.dos.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CouponDto {

    @JsonInclude(value = NON_NULL)
    String couponName;
    
    @JsonInclude(value = NON_NULL)
    Integer memberYears;
    
    @JsonInclude(value = NON_NULL)
    Integer orderTimes;
    
    @JsonInclude(value = NON_NULL)
    Float couponValue;
    
    @JsonInclude(value = NON_NULL)
    Integer duration;

    public String getCouponName() {
        return couponName;
    }

    public Integer getMemberYears() {
        return memberYears;
    }

    public Integer getOrderTimes() {
        return orderTimes;
    }

    public Float getCouponValue() {
        return couponValue;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public void setMemberYears(Integer memberYears) {
        this.memberYears = memberYears;
    }

    public void setOrderTimes(Integer orderTimes) {
        this.orderTimes = orderTimes;
    }

    public void setCouponValue(Float couponValue) {
        this.couponValue = couponValue;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }  
    
}
