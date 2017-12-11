package cmpe.dos.dto;

public class RatingDto {

    private Integer orderId;
    
    private Integer dishId;
    
    private Short score;
    
    private String comments;

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public Short getScore() {
        return score;
    }

    public String getComments() {
        return comments;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    
}
