package cmpe.dos.dao.impl;

/**
 * Created by Vencci on 29/11/2017.
 */
import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.dao.BranchCatalogDao;
import cmpe.dos.entity.BranchCatalog;

import java.util.List;

public class BranchCatalogDaoImpl extends AbstractHibernateDao<BranchCatalog> implements BranchCatalogDao{

    public BranchCatalogDaoImpl() {
        super(BranchCatalog.class);
    }


    @Override
    public List listBranchCatalog(int branch_id) {

        String hql = "select bc.branchId, bc.catalogId, cd.name, cd.description, DishDict.dishId, DishDict.name, DishDict.description, Dish.price, avg(Rating.score)" +
                "from BranchCatalog as bc, CatalogDict as cd, DishDict, Dish, Rating" +
                "where bc.branchId = ? and bc.catalogId = cd.catalogId and DishDict.catalogId = cd.catalogId and" +
                "DishDict.dishId = Dish.dishId and Rating.dishId = DishDict.dishId" +
                "group by select bc.branchId, bc.catalogId, cd.name, cd.description, DishDict.dishId, DishDict.name, DishDict.description, Dish.price";

        return doQueryListUntype(hql,true, branch_id);
    }
}
