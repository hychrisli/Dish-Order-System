package cmpe.dos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Branch;
import cmpe.dos.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    HibernateDao<Branch> dao;
    
    @Override
    public List<Branch> listBranches() {
	return dao.findAll();
    }

}
