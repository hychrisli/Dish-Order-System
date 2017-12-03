package cmpe.dos.service;

import cmpe.dos.entity.Rating;
import java.util.List;

public interface RatingService {

    public Boolean createRating(Rating rating);
    public Boolean deleteRating(Integer id);
    public List<Rating> showRatingsByUser(String username);
    public List<Rating> showRatingsByDish(Short branchId, Integer dishId);
}
