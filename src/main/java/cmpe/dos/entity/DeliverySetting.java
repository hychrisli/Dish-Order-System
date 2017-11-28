package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY_SETTING")
public class DeliverySetting {

	@Id
	@Column(name = "branch_id")
	private Short branchId;
	
	private Boolean providable;
	
	private Float fee;

	public DeliverySetting() {
		super();
	}

	public Short getBranchId() {
		return branchId;
	}

	public void setBranchId(Short branchId) {
		this.branchId = branchId;
	}

	public Boolean getProvidable() {
		return providable;
	}

	public void setProvidable(Boolean providable) {
		this.providable = providable;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "DeliverySetting [branchId=" + branchId + ", providable=" + providable + ", fee=" + fee + "]";
	}
	
	
}
