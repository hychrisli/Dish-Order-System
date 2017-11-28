package cmp226.dos.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Branch;
import cmpe.dos.service.BranchService;
import cmpe.dos.service.impl.BranchServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BranchServiceTest {

    @Mock
    HibernateDao<Branch> dao;
    
    @InjectMocks
    BranchService branchSvc = new BranchServiceImpl();
    
    private String name1, name2;
    private Branch branch1, branch2;
    private List<Branch> branchList;
    
    @Before
    public void init () {
	
	name1 = "My Branch";
	name2 = "Your Branch";
	
	branch1 = new Branch();
	branch1.setName(name1);
	
	branch2 = new Branch();
	branch2.setName(name2);

	branchList = new ArrayList<Branch>();
	branchList.add(branch1);
	branchList.add(branch2);
	
	Mockito.when(dao.findAll()).thenReturn(branchList);
    }
    
    
    @Test
    public void listBranches (){
	Assert.assertEquals(branchSvc.listBranches(), branchList);
    }
    
}
