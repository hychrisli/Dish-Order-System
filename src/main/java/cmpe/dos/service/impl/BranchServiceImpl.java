package cmpe.dos.service.impl;

import cmpe.dos.dao.HibernateDao;
import cmpe.dos.dto.BranchCatalogDto;
import cmpe.dos.dto.CatalogDetailDto;
import cmpe.dos.dto.DishDto;
import cmpe.dos.entity.*;
import cmpe.dos.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    HibernateDao<Branch> branchDao;
    @Autowired
    HibernateDao<BranchCatalog> brachCatDao;
    @Autowired
    HibernateDao<CatalogDict> catDictDao;
    @Autowired
    HibernateDao<Dish> dishDao;
    @Autowired
    HibernateDao<DishDict> dishDictDao;
    @Autowired
    HibernateDao<Rating> ratingDao;

    @Override
    public List<Branch> listBranches() {
        return branchDao.findAll();
    }

    @Override
    public BranchCatalogDto getBranchCatalogDish(int branchId) {
        Branch branch = branchDao.getById(branchId);
        BranchCatalogDto bcDto = new BranchCatalogDto();
        bcDto.setBranch_id(branch.getBranchId());
        bcDto.setCatalogs(new ArrayList<CatalogDetailDto>());
        List<BranchCatalog> branchCatalogs = brachCatDao.doQueryList("from BRANCH_CATALOG where branchId = ?", true, branchId);

        for (BranchCatalog bc : branchCatalogs) {
            CatalogDict catDict = catDictDao.getById(bc.getCatalogId());
            CatalogDetailDto catDetailDto = new CatalogDetailDto();
            catDetailDto.setCatalogId(catDict.getCatalogId());
            List<Dish> dishes = dishDao.doQueryList("DISH.* from DISH, DISH_DICT where DISH.dishId = DISH_DICT.dishId" +
                    "and DISH.branchId = ? and DISH_DICT.catalogId = ?", true, branchId, bc.getCatalogId());
            catDetailDto.setDishes(new ArrayList<DishDto>());
            catDetailDto.setDescription(catDict.getDescription());
            catDetailDto.setName(catDict.getName());

            for (Dish dish : dishes) {
                DishDto dishDto = new DishDto();
                List<Rating> ratings = ratingDao.doQueryList("RATING.* from RATING, DISH_DICT where RATING.dishId = DISH_DICT.dishId and DISH_DICT.dishId = ? group by RATING.dishId", true, dish.getDishId());
                int sum = 0;
                for (Rating rating : ratings) {
                    sum += rating.getScore();
                }
                float avg = (float)sum / (float)ratings.size();
                dishDto.setScore(avg);
                catDetailDto.getDishes().add(dishDto);
            }
        }
        return bcDto;
    }

}
