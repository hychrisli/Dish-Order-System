package cmpe.dos.service.impl;

import cmpe.dos.dao.OrderDao;
import cmpe.dos.dao.RatingDao;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.Rating;
import cmpe.dos.service.RatingService;
import cmpe.dos.service.RewardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDao dao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    RewardService rewardSvc;

    @Override
    public Boolean createRating(Rating rating) {

	Order order = orderDao.getById(rating.getOrderId());
	if (order.getPickOrDeliveryTime() == null) {
	    return false;
	}
	dao.create(rating);
	//rewardSvc.sendCommentReward(rating.getUsername());
	return true;

    }

    @Override
    public Boolean deleteRating(Integer id, String username) {

	if (dao.getById(id) == null)
	    return false;
	dao.deleteById(id);
	return true;
    }

    @Override
    public List<Rating> showRatingsByDish(Integer dishId) {

	return dao.getRatingByDishId(dishId);
    }

    @Override
    public List<Rating> showRatingsByUser(String username) {

	return dao.getRatingByUser(username);
    }

    @Override
    public List<Rating> showRatings() {
        return dao.findAll();
    }

    @Override
    public Boolean checkRatingUser(String username, Integer ratingId) {
        return (username.equals(dao.getRatingUser(ratingId))) ? true : false;
    }

    @Override
    public Boolean deleteRatingById(Integer id) {
        if (dao.getById(id) == null) {
            return false;
        }
        dao.deleteById(id);
        return true;
    }
}
