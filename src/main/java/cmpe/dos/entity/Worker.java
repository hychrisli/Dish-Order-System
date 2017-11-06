package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import cmpe.dos.entity.embed.WorkerId;

@Entity
public class Worker {

    @EmbeddedId
    private WorkerId workId;
    
/*    @Id
    @Column(name = "branch_id")
    private int branchId;*/
    
/*    @OneToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private User user;
    
    @OneToOne
    @MapsId("branch_id")
    @JoinColumn(name = "branch_id")
    private Branch branch;
*/
/*    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }*/

/*    public User getUser() {
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
    }*/
}
