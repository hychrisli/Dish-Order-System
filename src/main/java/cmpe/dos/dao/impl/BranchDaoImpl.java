package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Branch;

@Repository
public class BranchDaoImpl extends AbstractHibernateDao<Branch> {

    public BranchDaoImpl() {
	super(Branch.class);
    }
}
