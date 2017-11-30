package cmpe.dos.dao.impl;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.Rating;
import org.springframework.stereotype.Repository;

@Repository
public class RatingDaoImpl extends AbstractHibernateDao<Rating>{

    public RatingDaoImpl() {
        super(Rating.class);
    }
}
