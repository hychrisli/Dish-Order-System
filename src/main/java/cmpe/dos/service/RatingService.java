package cmpe.dos.service;

import cmpe.dos.entity.Rating;
import java.util.List;

public interface RatingService {

    public Boolean createRating(Rating rating);
    public Boolean deleteRating(Integer id, String username);
    public List<Rating> showRatingsByUser(String username);
    public List<Rating> showRatingsByDish(Short branchId, Integer dishId);
    public List<Rating> showRatings();
    public Boolean checkRatingUser(String username,Integer ratingId);
    public Boolean deleteRatingById(Integer id);
}
