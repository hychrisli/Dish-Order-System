package cmpe.dos.entity.embed;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import cmpe.dos.entity.Branch;
import cmpe.dos.entity.User;

@Embeddable
public class WorkerId implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -5106442985623171172L;

    @OneToOne
    @JoinColumn(name = "username", foreignKey = @ForeignKey(name = "worker_u_fk"))
    private User user;
    
    @OneToOne
    @JoinColumn(name = "branch_id", foreignKey = @ForeignKey(name = "worker_b_fk"))
    private Branch branch;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
