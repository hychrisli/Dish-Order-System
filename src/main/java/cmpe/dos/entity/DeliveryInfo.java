package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY_INFO")
public class DeliveryInfo {
	@Id
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "receiver_name")
	private String receiverName;

	private String phone;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zipcode;

	public DeliveryInfo() {
		super();
	}
	
	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "DeliveryInfo [orderId=" + orderId + ", receiverName=" + receiverName + ", phone=" + phone + ", street="
				+ street + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}

}
