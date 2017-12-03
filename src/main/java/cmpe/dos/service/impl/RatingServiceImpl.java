package cmpe.dos.service.impl;
import cmpe.dos.dao.OrderDao;
import cmpe.dos.dao.RatingDao;
import cmpe.dos.dao.RewardDao;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.Rating;
import cmpe.dos.entity.Reward;
import cmpe.dos.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDao dao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    RewardDao rewardDao;

    @Override
    public Boolean createRating(Rating rating) {

        Order order = orderDao.getById(rating.getOrderId());
        if(order.getPickOrDeliveryTime() == null) {
            return false;
        }
        dao.create(rating);
        sendReward(rating.getUsername());
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
    public List<Rating> showRatingsByDish(Short branchId, Integer dishId) {

        return dao.getRatingByDishId(branchId,dishId);
    }

    @Override
    public List<Rating> showRatingsByUser(String username) {

        return dao.getRatingByUser(username);
    }

    @Override
    public Boolean sendReward(String username) {
        Reward newReward = new Reward();

        newReward.setCouponId("commentReward");
        Date now = new Date(new Date().getTime());
        newReward.setValidStart(now);
        Date dueDate = new Date(new Date().getTime());
        addDays(dueDate, 20);
        newReward.setValidEnd(dueDate);
        newReward.setUsername(username);

        rewardDao.create(newReward);
        return true;
    }

    public static Date addDays(Date d, int days)
    {
        d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
        return d;
    }

    public List<Reward> getRewards(String username) {
        return rewardDao.doQueryList("from Reward where username =?", true,username);
    }
}
