package cmpe.dos.dao;

import cmpe.dos.entity.Dish;

public interface DishDao extends HibernateDao<Dish>{

	public Dish getDish(Short branchId, Integer dishId);
	
	public boolean deleteDishByDishId(Integer dishId);
}
