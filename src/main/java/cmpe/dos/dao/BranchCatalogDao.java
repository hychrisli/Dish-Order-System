package cmpe.dos.dao;

import cmpe.dos.entity.BranchCatalog;

import java.util.List;

/**
 * Created by Vencci on 30/11/2017.
 */
public interface BranchCatalogDao extends HibernateDao<BranchCatalog>{

    public List listBranchCatalog(int branch_id);
}
