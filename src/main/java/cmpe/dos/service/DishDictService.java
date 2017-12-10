package cmpe.dos.service;

import cmpe.dos.entity.DishDict;

public interface DishDictService {

    public DishDict findDishDict(Integer dishId);
    
    public boolean createDishDict(DishDict dishDict);
    
    public boolean updateDishDict(DishDict dishDict);
    
    public DishDict deleteDishDict(Integer dishId);
    
}
