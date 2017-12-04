package cmpe.dos.service;

import cmpe.dos.dto.DishDto;
import cmpe.dos.entity.Dish;

public interface DishService {
	
	public Dish getDish(Short branchId, Integer dishId);
	
	public void updateDish(Dish dish);

	public boolean createDish(DishDto dishdto);

	public boolean deleteDishFromBranch(Short branchId, Integer dishId);
}
