package cmpe.dos.mapper;

import cmpe.dos.dto.DishDto;
import cmpe.dos.dto.OrderDetailDto;
import cmpe.dos.dto.UserDto;
import cmpe.dos.dto.WorkerDto;
import cmpe.dos.entity.Dish;
import cmpe.dos.entity.DishDict;
import cmpe.dos.entity.OrderDishDetail;
import cmpe.dos.entity.User;


public class DishMapper {
    public static DishDto toDto(Dish dish, DishDict dishDict){
        if (dish == null || dishDict == null) return null;

        DishDto dishDto = new DishDto();
        dishDto.setDishId(dish.getDishId());
        dishDto.setName(dishDict.getName());
        dishDto.setBranch_id(dish.getBranchId());
        dishDto.setDescription(dishDict.getDescription());
        dishDto.setPrice(dish.getPrice());

        return dishDto;
    }

    public static Dish toPojo(DishDto dishDto){
        Dish dish = new Dish();
        dish.setBranchId(dishDto.getBranch_id());
        dish.setDishId(dishDto.getDishId());
        dish.setPrice(dishDto.getPrice());

        return dish;
    }

    public static DishDict toDishDict(DishDto dishDto) {
        DishDict dishDict = new DishDict();
        dishDict.setDescription(dishDto.getDescription());
        dishDict.setDishID(dishDto.getDishId());
        dishDict.setName(dishDto.getName());

        return dishDict;
    }
    
    public static OrderDetailDto toOrderDetailDto(OrderDishDetail detail, Dish dish, DishDict dishDict){
	OrderDetailDto orderDetailDto = new OrderDetailDto();
	orderDetailDto.setDishId(dishDict.getDishID());
	orderDetailDto.setDishName(dishDict.getName());
	orderDetailDto.setOrderQuantity(detail.getOrderQuantity());
	orderDetailDto.setPrice(dish.getPrice());
	
	return orderDetailDto;
    }

}
