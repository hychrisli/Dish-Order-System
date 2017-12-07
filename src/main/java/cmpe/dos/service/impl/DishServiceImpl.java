package cmpe.dos.service.impl;

import static cmpe.dos.exception.ErrorCode.ERR_BAD_REQUEST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.DishDao;
import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Dish;
import cmpe.dos.entity.DishDict;
import cmpe.dos.exception.AppException;
import cmpe.dos.service.DishService;

@Service
public class DishServiceImpl implements DishService {
    
    @Autowired
    DishDao dao;

    @Autowired
    HibernateDao<DishDict> dishDictDao;
    
    @Override
    public Dish getDish(Short branchId, Integer dishId) {
	return dao.getDish(branchId, dishId);
    }

    @Override
    public boolean updateDish(Dish dish) {
	Dish curDish = dao.getDish(dish.getBranchId(), dish.getDishId());
	if (curDish == null) 
	    return false;
	
	curDish.setInventoryQuantity(dish.getInventoryQuantity());
	curDish.setPrice(dish.getPrice());
	dao.update(curDish);
	return true;
    }

    @Override
    public boolean createDish(Dish dish) throws AppException {
	if (dishDictDao.getById(dish.getDishId()) == null)
	    throw new AppException(ERR_BAD_REQUEST, "Dish Not In Dish Dict");
	
	if (getDish(dish.getBranchId(), dish.getDishId()) != null)
	    return false;
	
	dao.create(dish);
	return true;
    }

    @Override
    public Dish deleteDishFromBranch(Short branchId, Integer dishId) {
	Dish dish = getDish(branchId, dishId);
	if ( dish == null)
	    return null;
	
	dao.delete(dish);
	return dish;
    }

    @Override
    public boolean deleteDishFromAllBranches(Integer dishId) {
	dao.deleteDishByDishId(dishId);
	return true;
    }
}
