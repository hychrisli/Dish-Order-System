package cmpe.dos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	public Boolean getDeliver() {
		return isDeliver;
	}

	public void setDeliver(Boolean deliver) {
		isDeliver = deliver;
	}

	@Column(nullable = false)
	private String username;
	
	@Column(name = "branch_id")
    private Short branchId;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_time", nullable = false)
    private Date orderTime;
	
    @Column(name = "total_price", nullable = false)
    private Float totalPrice;

    @Column(name = "is_deliver", nullable = false)
    private Boolean isDeliver;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	@Temporal(TemporalType.DATE)
    @Column(name = "pickup_deliver_time")
    private Date pickOrDeliveryTime;

	public Order() {
		super();
	}

	public Order(String username, Short branchId, Date orderTime, Float totalPrice, Boolean isDeliver) {
		super();
		this.username = username;
		this.branchId = branchId;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
		this.isDeliver = isDeliver;
	}



	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Short getBranchId() {
		return branchId;
	}

	public void setBranchId(Short branchId) {
		this.branchId = branchId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getIsDeliver() {
		return isDeliver;
	}

	public void setIsDeliver(Boolean isDeliver) {
		this.isDeliver = isDeliver;
	}

	public Date getPickOrDeliveryTime() {
		return pickOrDeliveryTime;
	}

	public void setPickOrDeliveryTime(Date pickOrDeliveryTime) {
		this.pickOrDeliveryTime = pickOrDeliveryTime;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", username=" + username + ", branchId=" + branchId + ", orderTime="
				+ orderTime + ", totalPrice=" + totalPrice + ", isDeliver=" + isDeliver + ", pickOrDeliveryTime="
				+ pickOrDeliveryTime + "]";
	}
    
    
	
}
