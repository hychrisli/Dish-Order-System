package cmpe.dos.service;

import cmpe.dos.entity.Rating;
import cmpe.dos.entity.Reward;
import java.util.List;

public interface RatingService {

    public Boolean createRating(Rating rating);
    public Boolean deleteRating(Integer id);
    public List<Rating> showRatingsByUser(String username);
    public List<Rating> showRatingsByDish(Short branchId, Integer dishId);
    public Boolean sendReward(String username);
    public List<Reward> getRewards(String username);
}
