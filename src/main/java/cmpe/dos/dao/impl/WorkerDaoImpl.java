package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Worker;

@Repository
public class WorkerDaoImpl extends AbstractHibernateDao<Worker>{

    public WorkerDaoImpl() {
	super(Worker.class);
    }
    
}
