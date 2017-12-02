package cmpe.dos.dao.impl;

import cmpe.dos.dao.AbstractHibernateDao;
import cmpe.dos.entity.CatalogDict;
import org.springframework.stereotype.Repository;

/**
 * Created by Vencci on 30/11/2017.
 */
@Repository
public class CatalogDictDaoImpl extends AbstractHibernateDao<CatalogDict> {

    public CatalogDictDaoImpl() {super(CatalogDict.class);}

}
