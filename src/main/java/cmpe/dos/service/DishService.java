package cmpe.dos.service;

import cmpe.dos.entity.Dish;
import cmpe.dos.exception.AppException;

public interface DishService {
	
	public Dish getDish(Short branchId, Integer dishId);
	
	public boolean updateDish(Dish dish);

	public boolean createDish(Dish dish) throws AppException;

	public Dish deleteDishFromBranch(Short branchId, Integer dishId);
	
	public boolean deleteDishFromAllBranches(Integer dishId);
}
