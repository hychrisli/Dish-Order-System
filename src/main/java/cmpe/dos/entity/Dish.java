package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "branch_id")
	private Short branchId;
	
	@Column(name = "dish_id")
	private Integer dishId;
	
	@Column(name = "inventory_quantity")
	private Short inventoryQuantity;
	
	private Float price;

	public Dish() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getBranchId() {
		return branchId;
	}

	public void setBranchId(Short branchId) {
		this.branchId = branchId;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public Short getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(Short inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", branchId=" + branchId + ", dishId=" + dishId + ", inventoryQuantity="
				+ inventoryQuantity + ", price=" + price + "]";
	}
	
	
}
