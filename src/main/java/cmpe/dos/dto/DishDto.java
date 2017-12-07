package cmpe.dos.dto;

/**
 * Created by Vencci on 29/11/2017.
 */
public class DishDto {
    Integer dishId;
    String name;
    String description;
    Float price;
    Double score;
    Short branch_id;

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Short getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Short branch_id) {
        this.branch_id = branch_id;
    }
}
