package cmpe.dos.dao;

import cmpe.dos.entity.Rating;
import cmpe.dos.entity.Reward;

import java.util.List;

public interface RatingDao extends HibernateDao<Rating>{

    public List<Rating> getRatingByUser(String username);
    public List<Rating> getRatingByDishId(Short branchId, Integer dishId);
}
