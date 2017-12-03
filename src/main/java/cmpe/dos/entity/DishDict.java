package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vencci on 30/11/2017.
 */
@Entity
@Table(name = "DISH_DICT")
public class DishDict {
    @Id
    @Column(name = "DISH_ID")
    private Integer dishID;

    @Column(name = "CATALOG_ID")
    private Short catalogID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PICTURE_DIR")
    private String pictureDir;

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public short getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(short catalogID) {
        this.catalogID = catalogID;
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

    public String getPictureDir() {
        return pictureDir;
    }

    public void setPictureDir(String pictureDir) {
        this.pictureDir = pictureDir;
    }
}
