package cmpe.dos.service;

import cmpe.dos.entity.Rating;
import java.util.List;

public interface RatingService {

    public Boolean createRating(Rating rating);
    public Boolean deleteRating(int id);
    public List<Rating> showRatingsByDish(int dish_id);
    public List<Rating> showRaingsByUser(String username);
}
