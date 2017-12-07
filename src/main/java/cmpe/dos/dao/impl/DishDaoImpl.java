package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.dao.DishDao;
import cmpe.dos.entity.Dish;

@Repository
public class DishDaoImpl extends AbstractHibernateDao<Dish> implements DishDao{

	public DishDaoImpl(){
		super(Dish.class);
	}

	@Override
	public Dish getDish(Short branchId, Integer dishId) {
		String hql = "from Dish where branchId = ? and dishId = ?";
		
		return doQueryFirst(hql, branchId, dishId);
	}

	@Override
	public boolean deleteDishByDishId(Integer dishId) {
	    executeHsql("delete from Dish where dishId = ? ", dishId);
	    return true;
	}	
}
