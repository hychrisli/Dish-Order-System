package cmpe.dos.service;

import cmpe.dos.dto.RatingDto;
import cmpe.dos.entity.Rating;
import cmpe.dos.exception.AppException;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingDto ratingDto, String username) throws AppException;
    public Boolean deleteRating(Integer id);
    public List<Rating> showRatingsByUser(String username);
    public List<Rating> showRatingsByDish(Integer dishId);
    public List<Rating> showRatings();
    public Boolean checkRatingUser(String username,Integer ratingId);
    public Boolean deleteRatingById(Integer id);
}
