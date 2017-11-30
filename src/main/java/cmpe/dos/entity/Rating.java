package cmpe.dos.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RATING")
public class Rating {

    @Id
    private Integer id;

    @Column(length = 20)
    private String username;

    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "dish_id")
    private Integer dish_id;

    @Column(length = 4)
    private short score;

    @Temporal(TemporalType.DATE)
    @Column(name = "timestamp", nullable = false)
    private Date timeStamp;

    @Column(length = 200)
    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getDish_id() {
        return dish_id;
    }

    public void setDish_id(Integer dish_id) {
        this.dish_id = dish_id;
    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
