package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DISH_DETAIL")
public class OrderDishDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "dish_id")
	private Integer dishId;
	
	@Column(name = "order_quantity", nullable = false)
	private Short orderQuantity;

	public OrderDishDetail() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public Short getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Short orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "OrderDishDetail [id=" + id + ", orderId=" + orderId + ", dishId=" + dishId + ", orderQuantity="
				+ orderQuantity + "]";
	}

}
