package cmpe.dos.controller;

import static cmpe.dos.constant.UrlConstant.DISH;
import static cmpe.dos.constant.UrlConstant.DISH_DICT;

import static cmpe.dos.config.security.UserRole.PRIV_ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmpe.dos.entity.Dish;
import cmpe.dos.entity.DishDict;
import cmpe.dos.exception.AppException;
import cmpe.dos.service.DishDictService;
import cmpe.dos.service.DishService;
import cmpe.dos.response.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@Api(tags = { "Dish" })
@SwaggerDefinition(tags = { @Tag(name = "Dish Controller", description = "Dish Controller Endpoints") })
@Transactional(rollbackFor = Exception.class)
public class DishController extends AbstractController {

    @Autowired
    DishService dishService;

    @Autowired
    DishDictService dishDictService;

    @ApiOperation(value = "Find a Dish in a Branch")
    @GetMapping(DISH + "/{branchId}/{dishId}")
    public ResponseEntity<JsonResponse> getDish(@PathVariable Short branchId, @PathVariable Integer dishId) {
	Dish dish = dishService.getDish(branchId, dishId);
	if (dish != null)
	    return success("dish", dish);

	return notFound();
    }

    @ApiOperation(value = "Create a Dish at a Branch")
    @PostMapping(DISH)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> addDish(@RequestBody Dish dish) throws AppException {
	if (dishService.createDish(dish))
	    return created("created", dish);

	return conflict();
    }

    @ApiOperation(value = "Update a Dish at a Branch")
    @PutMapping(DISH)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> updateDish(@RequestBody Dish dish) {
	if (dishService.updateDish(dish))
	    return success("updated", dish);

	return notFound();
    }

    @ApiOperation(value = "Delete a Dish From a Branch")
    @DeleteMapping(DISH + "/{branchId}/{dishId}")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> deleteDish(@PathVariable Short branchId, @PathVariable Integer dishId) {
	Dish dish = dishService.deleteDishFromBranch(branchId, dishId);
	if (dish != null)
	    return success("deleted", dish);

	return notFound();
    }

    @ApiOperation(value = "Get a Dish from Dish Dict")
    @GetMapping(DISH_DICT + "/{dishId}")
    public ResponseEntity<JsonResponse> getDishDict(@PathVariable Integer dishId) {
	DishDict dishDict = dishDictService.findDishDict(dishId);
	if (dishDict != null)
	    return success("dishDict", dishDict);
	return notFound();
    }

    @ApiOperation(value = "Create a Dish at Dish Dict")
    @PostMapping(DISH_DICT)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> createDishDict(@RequestBody DishDict dishDict) {
	if (dishDictService.createDishDict(dishDict))
	    return created("dishDict", dishDict);

	return conflict();
    }

    @ApiOperation(value = "Update a Dish at Dish Dict")
    @PutMapping(DISH_DICT)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> updateDishDict(@RequestBody DishDict dishDict) {
	if (dishDictService.updateDishDict(dishDict))
	    return success("dishDict", dishDict);

	return notFound();
    }

    @ApiOperation(value = "Delete a Dish from Dish Dict")
    @DeleteMapping(DISH_DICT + "/{dishId}")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> deleteDishDict(@PathVariable Integer dishId) {
	DishDict dishDict;
	dishDict = dishDictService.deleteDishDict(dishId);
	if (dishDict != null)
	    return success("deleted", dishDict);

	return notFound();
    }
}
