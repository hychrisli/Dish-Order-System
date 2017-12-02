package cmpe.dos.service;

import cmpe.dos.dto.BranchCatalogDto;
import cmpe.dos.entity.Branch;

import java.util.List;
public interface BranchService {

    public List<Branch> listBranches();
    public BranchCatalogDto getBranchCatalogDish(short branchId);
}
