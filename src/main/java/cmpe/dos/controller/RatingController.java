package cmpe.dos.controller;

import cmpe.dos.dto.RoleDto;
import cmpe.dos.dto.UserDto;
import cmpe.dos.entity.Order;
import cmpe.dos.entity.Rating;
import cmpe.dos.exception.ControllerExceptionHandler;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.RatingService;
import cmpe.dos.service.ReceiveOrderService;
import cmpe.dos.service.RoleService;
import cmpe.dos.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


import static cmpe.dos.config.security.UserRole.PRIV_ADMIN;
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
    ReceiveOrderService roService;

    @Autowired
    RoleService roleService;

    @ApiOperation(value = "View Ratings by self",response = JsonResponse.class)
    @GetMapping(RATING + "/self")
    public ResponseEntity<JsonResponse> getRatingsByUser(Principal principal) {

        RoleDto roleDto = roleService.getRoleDto(principal.getName());
        if(roleDto.isAdmin()) {
            List<Rating> ratingsByAdmin= ratingService.showRatings();
            if(!ratingsByAdmin.isEmpty() && ratingsByAdmin != null)
                return success("userRatings", ratingsByAdmin);
            else return notFound();
        }

        List<Rating> ratingsByUser = ratingService.showRatingsByUser(principal.getName());
        if(!ratingsByUser.isEmpty() && ratingsByUser != null ) {
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
        return badRequest("Have not confirmed delivery ");
    }

    //administrator can delete any user's rating
    //users only can delete their own rating
    @ApiOperation(value = "Delete A Rating")
    @DeleteMapping("user/"+ RATING + "/{id}")
    public ResponseEntity<JsonResponse> deleteRating(@PathVariable Integer id, Principal principal) {
        RoleDto roleDto = roleService.getRoleDto(principal.getName());
        if(roleDto.isAdmin()) {
            if(ratingService.deleteRatingById(id)){
                return success("deleted", id);
            }
            return notFound();
        }

        if(!ratingService.checkRatingUser(principal.getName(),id))
            return badRequest("You have no access to others rating");

        if(ratingService.showRatingsByUser(principal.getName())!= null
                && ratingService.deleteRating(id, principal.getName()))
            return success("deleted", id);
        return notFound();
    }


    //User can confirm his own unreceived order
    @ApiOperation(value = "Confirm receive user's order",response = JsonResponse.class)
    @PostMapping("confirm/order"+ "/{orderId}")
    public ResponseEntity<JsonResponse> confirmReceiveOrder(Principal principal, @PathVariable Integer orderId){

        if(roService.showNonReceivedOrder(principal.getName()).isEmpty()
                || roService.showNonReceivedOrder(principal.getName()) == null)
            return badRequest("No unreceived order");

        if(roService.confirmReceiveOrder(orderId, principal.getName())!= null ) {
            return success("confirmed",roService.confirmReceiveAnOrder(orderId));
        }

        return notFound();
    }


    //administrator can view all unreceived orders
    //users only can view their own unreceived orders
    @ApiOperation(value = "show all unreceived orders",response =  JsonResponse.class)
    @GetMapping("/unreceived/all")
    public ResponseEntity<JsonResponse> allUnreceivedOrder(Principal principal) {

        RoleDto roleDto = roleService.getRoleDto(principal.getName());
        if (roleDto.isAdmin()) {
            List<Order> allUnreceived = roService.showallUnreceivedOrders();
            if (allUnreceived != null && !allUnreceived.isEmpty())
                return success("allUnreceived", allUnreceived);

        } else {
            List<Order> unreceived = roService.showNonReceivedOrder(principal.getName());
            if(unreceived != null && !unreceived.isEmpty())
                return success("myUnreceived",unreceived);
            return badRequest("order all received by user "+ principal.getName());
        }

        return notFound();
    }

}
