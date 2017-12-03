package cmpe.dos.controller;

import static cmpe.dos.constant.UrlConstant.DISH;
import static cmpe.dos.constant.UrlConstant.USER;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import static cmpe.dos.config.security.UserRole.PRIV_ADMIN;

import cmpe.dos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmpe.dos.dto.UserDto;
import cmpe.dos.dto.WorkerDto;
import cmpe.dos.entity.User;
import cmpe.dos.dto.DishDto;
import cmpe.dos.service.DishService;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;


@RestController
@Api(tags = {"Dish"})
@SwaggerDefinition(tags = { @Tag(name="Dish Controller", description="Dish Controller Endpoints")})
@Transactional(rollbackFor = Exception.class)
public class DishController extends AbstractController {

    @Autowired
    DishService dishService;


    @ApiOperation(value = "Create a Dish")
    @PostMapping(DISH)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> addUser(@RequestBody DishDto dishDto){
        if (dishService.createDish(dishDto))
            return created("created", dishDto.getDishId());

        return conflict();
    }

    @ApiOperation(value = "Delete A User")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> deleteUser(@PathVariable Integer dishId){
        if (dishService.deleteDish(dishId))
            return success("deleted", dishId);

        return notFound();
    }

}
