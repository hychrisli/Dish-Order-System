package cmpe.dos.service.impl;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.entity.Rating;
import cmpe.dos.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    HibernateDao<Rating> dao;

    @Override
    public Boolean createRating(Rating rating) {

        dao.create(rating);
        return true;

    }

    @Override
    public Boolean deleteRating(int id) {

        if (dao.getById(id) == null)
            return false;
        dao.deleteById(id);
        return true;
    }

    @Override
    public List<Rating> showRatingsByDish(int dish_id) {

        List<Rating> ratingsByDish = new ArrayList<>();

//        if(dao.getById(dish_id)!=null) {
//            ratingsByDish.add(dao.getById(dish_id));
//        }
        ratingsByDish = dao.doQueryList("select * from RATING where dish_id = ?", true, dao);
        return ratingsByDish;

    }

    @Override
    public List<Rating> showRaingsByUser(String username) {
        List<Rating> ratingsByUser = new ArrayList<>();

        if(dao.getById(username)!=null) {
            ratingsByUser.add(dao.getById(username));
        }
        return ratingsByUser;
    }
}
