package cmpe.dos.dao;

/**
 * Created by Vencci on 30/11/2017.
 */
import cmpe.dos.entity.Rating;

import java.util.List;

public interface RatingDao extends HibernateDao<Rating>{

    public List<Rating> getRatingByUser(Short branchId, Integer dishId, String username);
    public List<Rating> getRatingByDishId(Short branchId, Integer dishId);

}
