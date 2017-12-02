package cmpe.dos.dto;

import java.util.List;

/**
 * Created by Vencci on 29/11/2017.
 */
public class BranchCatalogDto {
    Short branch_id;
    List<CatalogDetailDto> catalogs;

    public Short getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Short branch_id) {
        this.branch_id = branch_id;
    }

    public List<CatalogDetailDto> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<CatalogDetailDto> catalogs) {
        this.catalogs = catalogs;
    }
}
