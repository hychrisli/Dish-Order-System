package cmpe.dos.service.impl;

import cmpe.dos.dto.DishDto;
import cmpe.dos.mapper.DishMapper;
import cmpe.dos.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

	@Override
	public boolean createDish (DishDto dishDto) {
		if ( dao.getById(dishDto.getDishId()) != null)
			return false;

		dao.create(DishMapper.toPojo(dishDto));
		return true;
	}

	@Override

	public boolean deleteDish(int dishId) {
		if (dao.getById(dishId) == null)
			return false;
		dao.deleteById(dishId);
		return true;
	}
	
}
