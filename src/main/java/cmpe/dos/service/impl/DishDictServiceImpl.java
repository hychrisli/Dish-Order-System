package cmpe.dos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import cmpe.dos.dao.DishDao;
import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.DishDict;
import cmpe.dos.service.DishDictService;

public class DishDictServiceImpl implements DishDictService {

    @Autowired
    HibernateDao<DishDict> dictDao;
    
    @Autowired
    DishDao dishDao;
    
    @Override
    public DishDict findDishDict(Integer dishId) {
	return dictDao.getById(dishId);
    }

    @Override
    public boolean createDishDict(DishDict dishDict) {
	dictDao.create(dishDict);
	return true;
    }

    @Override
    public boolean updateDishDict(DishDict dishDict) {
	dictDao.update(dishDict);
	return true;
    }

    @Override
    public DishDict deleteDishDict(Integer dishId) {
	dishDao.deleteDishByDishId(dishId);
	DishDict dishDict = dictDao.getById(dishId);
	if (dishDict == null)
	    return null;
	dictDao.deleteById(dishId);
	return dishDict;
    }
}
