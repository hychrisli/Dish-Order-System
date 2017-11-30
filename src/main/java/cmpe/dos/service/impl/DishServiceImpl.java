package cmpe.dos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpe.dos.dao.DishDao;
import cmpe.dos.entity.Dish;
import cmpe.dos.service.DishService;

@Service
public class DishServiceImpl implements DishService{
	@Autowired
	DishDao dao;

	
	@Override
	public Dish getDish(Short branchId, Integer dishId) {
		
		return dao.getDish(branchId, dishId);
	}

	@Override
	public void updateDish(Dish dish) {
		dao.update(dish);
		
	}
	
}
