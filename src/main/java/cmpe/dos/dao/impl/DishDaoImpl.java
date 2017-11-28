package cmpe.dos.dao.impl;

import org.springframework.stereotype.Repository;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Dish;

@Repository
public class DishDaoImpl extends AbstractHibernateDao<Dish> {

	public DishDaoImpl(){
		super(Dish.class);
	}
}
