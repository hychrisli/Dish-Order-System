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
    @GetMapping(RATING + "/{username}&{branchId}&{dishId}")
    public ResponseEntity<JsonResponse> getRatingsByUser(Short branchId, Integer dishId, String username) {

        List<Rating> ratingsByUser = ratingService.showRatingsByUser(branchId, dishId,username);

        if(!ratingsByUser.isEmpty()) {
            return success("userRatings", ratingsByUser);
        }
        return notFound();
    }

    @ApiOperation(value = "View Ratings by Dish",response = JsonResponse.class)
    @GetMapping(DISH+"/{dish_id}/"+RATING)
    public ResponseEntity<JsonResponse> getRatingsByDish(@PathVariable Short branch_id, Integer dish_id) {

        List<Rating> ratingsByDish = ratingService.showRatingsByDish(branch_id, dish_id);

        if (!ratingsByDish.isEmpty()) {
            return success("dishRatings", ratingsByDish);
        }
        return notFound();
    }

    @ApiOperation(value = "Add A Rating on A Dish")
    @PostMapping(RATING)
    public ResponseEntity<JsonResponse> addRating(@RequestBody Rating rating){

        if(ratingService.createRating(rating)) {
            return created("created", true);
        }

        return badRequest("Have not confirmed dilivery ");
    }


    @ApiOperation(value = "Delete A Rating")
    @DeleteMapping(RATING + "/{id}")
    public ResponseEntity<JsonResponse> deleteRating(@PathVariable Integer id){

        if(ratingService.deleteRating(id))
            return success("deleted", id);

        return notFound();
    }


}
