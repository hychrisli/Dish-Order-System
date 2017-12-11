package cmpe.dos.service.impl;

import static cmpe.dos.exception.ErrorCode.ERR_BAD_REQUEST;
import static org.slf4j.LoggerFactory.getLogger;

import cmpe.dos.dao.OrderDao;
import cmpe.dos.dao.RatingDao;
import cmpe.dos.dto.RatingDto;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.Rating;
import cmpe.dos.exception.AppException;
import cmpe.dos.service.RatingService;
import cmpe.dos.service.RewardService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    
    private final static Logger LOGGER = getLogger(RatingServiceImpl.class);

    @Autowired
    RatingDao dao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    RewardService rewardSvc;

    @Override
    public Rating createRating(RatingDto ratingDto, String username) throws AppException {

	Rating rating = new Rating();
	
	Order order = orderDao.getById(ratingDto.getOrderId());
	
	if (order == null)
	    throw new AppException(ERR_BAD_REQUEST, "Cannot find order");
		    
	if (order.getPickOrDeliveryTime() == null )
	    throw new AppException(ERR_BAD_REQUEST, "Order not delivered");
	
	LOGGER.info(order.getUsername());
	
	if ( !order.getUsername().equals(username))
	    throw new AppException(ERR_BAD_REQUEST, "User doesn't have this order");
	
	rating.setBranchId(order.getBranchId());
	rating.setDishId(ratingDto.getDishId());
	rating.setOrderId(ratingDto.getOrderId());
	rating.setComments(ratingDto.getComments());
	rating.setUsername(username);
	rating.setTimeStamp(new Date());
	rating.setScore(ratingDto.getScore());
	
	dao.create(rating);
	return rating;
    }

    @Override
    public Boolean deleteRating(Integer id) {

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
