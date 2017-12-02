package cmpe.dos.service.impl;

import cmpe.dos.dao.OrderDao;
import cmpe.dos.dao.RatingDao;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.Rating;
import cmpe.dos.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDao dao;

    @Autowired
    OrderDao orderDao;


    @Override
    public Boolean createRating(Rating rating) {

        Order order = orderDao.getById(rating.getOrderId());
        if(order.getPickOrDeliveryTime() == null) {
            return false;
        }
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

    //@Override
    public List<Rating> showRatingsByDish(Short branchId, Integer dishId) {

        return dao.getRatingByDishId(branchId,dishId);
    }

    @Override
    public List<Rating> showRatingsByUser(Short branchId, Integer dishId, String username) {

        return dao.getRatingByUser(branchId, dishId, username);
    }
}
