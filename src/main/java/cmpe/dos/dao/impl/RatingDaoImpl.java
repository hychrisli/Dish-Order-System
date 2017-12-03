package cmpe.dos.dao.impl;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.dao.RatingDao;
import cmpe.dos.entity.Rating;
import cmpe.dos.entity.Reward;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingDaoImpl extends AbstractHibernateDao<Rating> implements RatingDao{

    public RatingDaoImpl() {
        super(Rating.class);
    }

    @Override
    public List<Rating> getRatingByUser(String username) {
        String hql = "from Rating where username = ? ";
        return doQueryList(hql, true, username);
    }

    @Override
    public List<Rating> getRatingByDishId(Short branchId, Integer dishId) {
        String hql = "from Rating where branchId = ? and dishId = ? ";
        return doQueryList(hql, true,branchId, dishId);
    }

}
