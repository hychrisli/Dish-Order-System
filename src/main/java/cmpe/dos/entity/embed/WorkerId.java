package cmpe.dos.entity.embed;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import cmpe.dos.entity.Branch;
import cmpe.dos.entity.User;

@Embeddable
public class WorkerId implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 9069680714305949802L;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;
    
    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
