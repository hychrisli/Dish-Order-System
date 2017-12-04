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
import cmpe.dos.dto.DishDto;
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
    public ResponseEntity<JsonResponse> getDish(@PathVariable Short branchId, @PathVariable Integer dishId){
	Dish dish = dishService.getDish(branchId, dishId);
	if (dish != null)
	    return success("dish", dish);
	
	return notFound();
    }
    
    @ApiOperation(value = "Create a Dish")
    @PostMapping(DISH)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> addDish(@RequestBody DishDto dishDto) {
	if (dishService.createDish(dishDto))
	    return created("created", dishDto.getDishId());

	return conflict();
    }
    
    
    @ApiOperation(value = "Delete a Dish From a Branch")
    @DeleteMapping(DISH + "/{branchId}/{dishId}")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> deleteDish(@PathVariable Short branchId, @PathVariable Integer dishId) {
	if (dishService.deleteDishFromBranch(branchId, dishId))
	    return success("deleted", dishId);
	
	return notFound();
    }

    @ApiOperation(value = "Get a Dish from Dish Dict")
    @GetMapping(DISH_DICT)
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
	dishDictService.createDishDict(dishDict);
	return created("dishDict", dishDict);
    }
    
    @ApiOperation(value = "Update a Dish at Dish Dict")
    @PutMapping(DISH_DICT)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> updateDishDict(@RequestBody DishDict dishDict){
	dishDictService.updateDishDict(dishDict);
	return success("dishDict", dishDict);
    }
   
    @ApiOperation(value = "Delete a Dish from Dish Dict")
    @DeleteMapping(DISH_DICT)
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> deleteDishDict(@PathVariable Integer dishId) {
	DishDict dishDict = dishDictService.deleteDishDict(dishId);
	if (dishDict != null)
	    return success("deleted", dishDict);
	
	return notFound();
    }
}
