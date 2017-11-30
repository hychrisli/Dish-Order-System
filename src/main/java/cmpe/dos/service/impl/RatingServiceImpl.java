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
    public Boolean deleteRating(Integer id) {

        if (dao.getById(id) == null)
            return false;
        dao.deleteById(id);
        return true;
    }

    @Override
    public List<Rating> showRatingsByDish(Integer dish_id) {
        Object[] dishID = new Integer[1];
        dishID[0]= dish_id;

        List<Rating> ratingsByDish = new ArrayList<>();
//        if(dao.getById(dish_id)!=null) {
//            ratingsByDish.add(dao.getById(dish_id));
//        }
        String hql = "select r.username, r.dish_id, r.comments from RATING AS r where r.dish_id = ?";
        ratingsByDish = dao.doQueryList(hql, true, dishID);
        return ratingsByDish;
    }

    @Override
    public List<Rating> showRaingsByUser(String username) {

        List<Rating> ratingsByUser = new ArrayList<>();

//        Integer userID = null;
//        for(Rating r: dao.findAll()){
//            if(r.getUsername() == username)
//                userID = r.getId();
//        }
//   if(userID != null) {
//        ratingsByUser.add(dao.getById(userID));
//    }
        Object[] u = new Object[1];
        u[0] = username;
        String hql = "select username, dish_id, comments from RATING where username = ?";
        ratingsByUser = dao.doQueryList(hql, true, u);

        return ratingsByUser;
    }
}
