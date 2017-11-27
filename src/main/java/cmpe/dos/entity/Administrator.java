package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ADMINISTRATOR")
public class Administrator {

    @Id
    @Column(length = 20)
    private String username;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
