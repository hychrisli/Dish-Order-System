package cmpe.dos.controller;

import cmpe.dos.entity.Rating;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.RatingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cmpe.dos.constant.UrlConstant.DISH;
import static cmpe.dos.constant.UrlConstant.RATING;

@RestController
public class RatingController extends AbstractController {

    @Autowired
    RatingService ratingService;

    @ApiOperation(value = "View Ratings by User",response = JsonResponse.class)
    @GetMapping(RATING + "/{id}")
    public ResponseEntity<JsonResponse> getRatingsByUser(String username){

        List<Rating> ratingsByUser = ratingService.showRaingsByUser(username);

        if(!ratingsByUser.isEmpty()) {
            return success("userRatings", ratingsByUser);
        }
        return notFound();
    }

    @ApiOperation(value = "View Ratings by Dish",response = JsonResponse.class)
    @GetMapping(DISH+"/{dish_id}"+ RATING + "/{id}")
    public ResponseEntity<JsonResponse> getRatingsByDish(int dish_id) {

        List<Rating> ratingsByDish = ratingService.showRatingsByDish(dish_id);

        if (!ratingsByDish.isEmpty()) {
            return success("dishRatings", ratingsByDish);
        }
        return notFound();
    }

    @ApiOperation(value = "Add A Rating")
    @PostMapping(DISH+"/{dish_id}"+ RATING + "/{id}")
    public ResponseEntity<JsonResponse> addRating(@RequestBody Rating rating ){
        return created("created", ratingService.createRating(rating));
    }

    @ApiOperation(value = "Delete A Rating")
    @DeleteMapping(DISH +"/{dish_id}"+ RATING + "/{id}")
    public ResponseEntity<JsonResponse> deleteRating(@PathVariable int id){

        if(ratingService.deleteRating(id))
            return success("deleted", id);

        return notFound();
    }


}
