package cmpe.dos.controller;

import cmpe.dos.dto.RatingDto;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.Rating;
import cmpe.dos.exception.AppException;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.RatingService;
import cmpe.dos.service.ReceiveOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


import static cmpe.dos.constant.UrlConstant.DISH;
import static cmpe.dos.constant.UrlConstant.RATING;

@RestController
@Api(tags = {"Rating"})
@SwaggerDefinition(tags = { @Tag(name="Rating Controller", description="Rating Controller Endpoints")})
@Transactional(rollbackFor = Exception.class)
public class RatingController extends AbstractController {

    @Autowired
    RatingService ratingService;

    @Autowired
    ReceiveOrderService cdos;


    @ApiOperation(value = "View Ratings by User",response = JsonResponse.class)
    @GetMapping(RATING + "/{username}")
    public ResponseEntity<JsonResponse> getRatingsByUser(String username) {

        List<Rating> ratingsByUser = ratingService.showRatingsByUser(username);

        if(!ratingsByUser.isEmpty()) {
            return success("userRatings", ratingsByUser);
        }
        return notFound();
    }

    @ApiOperation(value = "View Ratings by Dish",response = JsonResponse.class)
    @GetMapping(DISH + "/{dishId}"+ "branch" +"/{branchId}/"+ RATING )
    public ResponseEntity<JsonResponse> getRatingsByDish(@PathVariable Short branchId, @PathVariable Integer dishId) {

        List<Rating> ratingsByDish = ratingService.showRatingsByDish(branchId, dishId);

        if (!ratingsByDish.isEmpty()) {

            return success("dishRatings", ratingsByDish );
        }
        return notFound();
    }

    @ApiOperation(value = "Add A Rating on A Dish")
    @PostMapping(RATING)
    public ResponseEntity<JsonResponse> addRating(@RequestBody RatingDto ratingDto, Principal principal) throws AppException{

	Rating rating = ratingService.createRating(ratingDto, principal.getName());
	
        if(rating != null) {
            return created("created", rating);
        }
        
        return badRequest("Have not confirmed delivery ");
    }

    @ApiOperation(value = "Delete A Rating")
    @DeleteMapping(RATING + "/{id}")
    public ResponseEntity<JsonResponse> deleteRating(@PathVariable Integer id){

        if(ratingService.deleteRating(id))
            return success("deleted", id);

        return notFound();
    }
}
