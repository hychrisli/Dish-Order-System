package cmpe.dos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reward {
	
	@Id
	@Column(name = "reward_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rewardId;
	
	@Column(name = "coupon_id")
	private Integer couponId;
	
	@Column(name = "valid_start")
	private Date validStart;
	
	@Column(name = "valid_end")
	private Date validEnd;
	
	@Column(name = "used_date")
	private Date used_date;

	public Reward() {
		super();
	}

	public Integer getRewardId() {
		return rewardId;
	}

	public void setRewardId(Integer rewardId) {
		this.rewardId = rewardId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Date getValidStart() {
		return validStart;
	}

	public void setValidStart(Date validStart) {
		this.validStart = validStart;
	}

	public Date getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(Date validEnd) {
		this.validEnd = validEnd;
	}

	public Date getUsed_date() {
		return used_date;
	}

	public void setUsed_date(Date used_date) {
		this.used_date = used_date;
	}

	@Override
	public String toString() {
		return "Reward [rewardId=" + rewardId + ", couponId=" + couponId + ", validStart=" + validStart + ", validEnd="
				+ validEnd + ", used_date=" + used_date + "]";
	}
	
	
}
