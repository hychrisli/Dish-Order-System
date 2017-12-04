package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.DishDict;
import cmpe.dos.service.DishDictService;
import cmpe.dos.service.DishService;

@Service
public class DishDictServiceImpl implements DishDictService {

    @Autowired
    HibernateDao<DishDict> dictDao;
    
    @Autowired
    DishService dishSvc;
    
    @Override
    public DishDict findDishDict(Integer dishId) {
	return dictDao.getById(dishId);
    }

    @Override
    public boolean createDishDict(DishDict dishDict) {
	if (findDishDict(dishDict.getDishID()) != null)
	    return false;
	
	dictDao.create(dishDict);
	return true;
    }

    @Override
    public boolean updateDishDict(DishDict dishDict) {
	DishDict curDishDict = findDishDict(dishDict.getDishID());
	if (curDishDict == null)
	    return false;
	    
	dictDao.update(dishDict);
	return true;
    }

    @Override
    @Transactional
    public DishDict deleteDishDict(Integer dishId){
	dishSvc.deleteDishFromAllBranches(dishId);
	DishDict dishDict = dictDao.getById(dishId);
	if (dishDict == null)
	    return null;
	
	dictDao.deleteById(dishId);
	return dishDict;
    }
}
