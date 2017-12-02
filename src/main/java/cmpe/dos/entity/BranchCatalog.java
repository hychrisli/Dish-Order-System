package cmpe.dos.entity;

/**
 * Created by Vencci on 29/11/2017.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BRANCH_CATALOG")
public class BranchCatalog {


    @Id
    @Column(length = 20)
    private Integer ID;

    @Column(name="CATALOG_ID")
    private Short catalogId;

    @Column(name = "BRANCH_ID")
    private Short branchId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public short getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(short catalogId) {
        this.catalogId = catalogId;
    }

    public short getBranchId() {
        return branchId;
    }

    public void setBranchId(short branchId) {
        this.branchId = branchId;
    }

}
