package cmpe.dos.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

public class DeliverInfoDto {

	@JsonInclude(value = NON_NULL)
    @ApiModelProperty(required = true)
	private String receiverName;

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

	@Override
	public String toString() {
		return "DeliverInfo [receiverName=" + receiverName + ", phone=" + phone + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
}
