package cmpe.dos.controller;

import cmpe.dos.entity.Order;
import cmpe.dos.entity.Rating;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.RatingService;
import cmpe.dos.service.ReceiveOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static cmpe.dos.constant.UrlConstant.DISH;
import static cmpe.dos.constant.UrlConstant.RATING;

@RestController
@Api(tags = {"Rating"})
public class RatingController extends AbstractController {

    @Autowired
    RatingService ratingService;

    @Autowired
    ReceiveOrderService cdos;

    @ApiOperation(value = "View Ratings by User",response = JsonResponse.class)
    @GetMapping(RATING + "/{username}")
    public ResponseEntity<JsonResponse> getRatingsByUser(Short branchId, Integer dishId, String username) {

        List<Rating> ratingsByUser = ratingService.showRatingsByUser(branchId, dishId, username);

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

    @ApiOperation(value = "Confirm receive user's order",response = JsonResponse.class)
    @PostMapping("confirm" + "/user"+ "/{username}")
    public ResponseEntity<JsonResponse> confirmReceiveOrder(@PathVariable  Integer orderId){

        List<Order> confirmOrder = cdos.confirmReceiveOrder(orderId);
        if(confirmOrder!= null)
            return success("confirmed", confirmOrder);
        return notFound();
    }

    @ApiOperation(value = "show unreceived orders",response =  JsonResponse.class)
    @GetMapping("customer"+"/{username}" + "/unreceived")
    public ResponseEntity<JsonResponse> unreceivedOrder(@PathVariable String username) {
        List<Order> unreceived = cdos.showNonReceivedOrder(username);
        if(unreceived != null)
            return success("unreceived", unreceived);
        return badRequest("order all received by user "+ username);
    }

}
