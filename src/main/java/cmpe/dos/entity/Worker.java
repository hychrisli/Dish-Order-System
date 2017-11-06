package cmpe.dos.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import cmpe.dos.entity.embed.WorkerId;

@Entity
public class Worker {

    @EmbeddedId
    private WorkerId workId;

    public WorkerId getWorkId() {
        return workId;
    }

    public void setWorkId(WorkerId workId) {
        this.workId = workId;
    }
   
}
