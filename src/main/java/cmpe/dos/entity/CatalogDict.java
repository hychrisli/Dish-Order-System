package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vencci on 30/11/2017.
 */
@Entity
@Table(name = "CATALOG_DICT")
public class CatalogDict {
    @Id
    @Column(name = "CATALOG_ID")
    private Short catalogId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public short getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(short catalogId) {
        this.catalogId = catalogId;
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
}
