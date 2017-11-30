package cmpe.dos.service;

import cmpe.dos.entity.Dish;

public interface DishService {
	
	public Dish getDish(Short branchId, Integer dishId);
	
	public void updateDish(Dish dish);
}
