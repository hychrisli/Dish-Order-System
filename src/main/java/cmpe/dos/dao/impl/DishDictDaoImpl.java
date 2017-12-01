package cmpe.dos.dao.impl;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.DishDict;
import org.springframework.stereotype.Repository;

/**
 * Created by Vencci on 30/11/2017.
 */
@Repository
public class DishDictDaoImpl extends AbstractHibernateDao<DishDict> {

    public DishDictDaoImpl() {super(DishDict.class);}

}
