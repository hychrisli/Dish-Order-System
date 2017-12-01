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
    public BranchCatalogDto getBranchCatalogDish(short branchId) {
        Branch branch = branchDao.getById(branchId);
        BranchCatalogDto bcDto = new BranchCatalogDto();
        bcDto.setBranch_id(branch.getBranchId());
        bcDto.setCatalogs(new ArrayList<CatalogDetailDto>());
        List<BranchCatalog> branchCatalogs = brachCatDao.doQueryList("from BranchCatalog where branchId = ?", true, branchId);

        for (BranchCatalog bc : branchCatalogs) {
            CatalogDict catDict = catDictDao.getById(bc.getCatalogId());
            CatalogDetailDto catDetailDto = new CatalogDetailDto();
            catDetailDto.setCatalogId(catDict.getCatalogId());
            catDetailDto.setName(catDict.getName());
            catDetailDto.setDescription(catDict.getDescription());
            List dishes = dishDao.doQueryList("select b.dishID, b.name, b.description, a.price from Dish as a, DishDict as b where a.dishId = b.dishID" +
                    " and a.branchId = ? and b.catalogID = ?", true, branchId, bc.getCatalogId());
            catDetailDto.setDishes(new ArrayList<DishDto>());
            catDetailDto.setDescription(catDict.getDescription());
            catDetailDto.setName(catDict.getName());

            for (int i = 0; i < dishes.size(); i++) {
                DishDto dishDto = new DishDto();
                dishDto.setDishId((Integer)((Object[])dishes.get(i))[0]);
                dishDto.setName((String)((Object[])dishes.get(i))[1]);
                dishDto.setDescription((String)((Object[])dishes.get(i))[2]);
                dishDto.setPrice((Float)((Object[])dishes.get(i))[3]);
                List ratings = ratingDao.doQueryList("select a.dishId, avg(a.score) from Rating as a where a.dishId = ? group by a.dishId", true, (Integer)((Object[])dishes.get(i))[0]);
                if (ratings.isEmpty()) {
                    dishDto.setScore(0.0);
                } else {
                    dishDto.setScore((Double) ((Object[]) ratings.get(0))[1]);
                }
                catDetailDto.getDishes().add(dishDto);
            }
            bcDto.getCatalogs().add(catDetailDto);
        }
        return bcDto;
    }
    @Override
    public CatalogDetailDto getDishById(short branchId) {
        CatalogDetailDto catDetailDto = new CatalogDetailDto();
        catDetailDto.setDishes(new ArrayList<DishDto>());
        List dishes = dishDao.doQueryList("select a.dishId, a.price from Dish as a as a where" +
                " a.branchId = ?", true, branchId);
        for (int i = 0; i < dishes.size(); i++) {
            DishDto dishDto = new DishDto();
            dishDto.setDishId((Integer)((Object[])dishes.get(i))[0]);
            dishDto.setPrice((Float)((Object[])dishes.get(i))[1]);
            catDetailDto.getDishes().add(dishDto);
        }
        return catDetailDto;
    }
}
