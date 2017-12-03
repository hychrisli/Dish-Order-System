package cmpe.dos.dto;

import java.util.List;

/**
 * Created by Vencci on 30/11/2017.
 */
public class CatalogDetailDto {
    Short catalogId;
    String name;
    String description;
    List<DishDto> dishes;

    public Short getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Short catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DishDto> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishDto> dishes) {
        this.dishes = dishes;
    }
}
