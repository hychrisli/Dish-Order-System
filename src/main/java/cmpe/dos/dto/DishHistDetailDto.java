package cmpe.dos.dto;

public class DishHistDetailDto {
    
    Integer dishId;
    String name;
    Short orderQuantity;
    
    public Integer getDishId() {
        return dishId;
    }
    public String getName() {
        return name;
    }
    public Short getOrderQuantity() {
        return orderQuantity;
    }
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOrderQuantity(Short orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    
    
    
    
}
