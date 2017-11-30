package cmpe.dos.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;

public class OrderDetailDto {

	@JsonInclude(value = NON_NULL)
	private Integer dishId;
	
	@JsonInclude(value = NON_NULL)
	private String dishName;
	
	@JsonInclude(value = NON_NULL)
	private Float price;
	
	@JsonInclude(value = NON_NULL)
	private Short orderQuantity;

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Short getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Short orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "OrderDetailDto [dishId=" + dishId + ", dishName=" + dishName + ", price=" + price + ", orderQuantity="
				+ orderQuantity + "]";
	}
	
	
}
