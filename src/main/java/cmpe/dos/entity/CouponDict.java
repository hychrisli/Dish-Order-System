package cmpe.dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUPON_DICT")
public class CouponDict {
	@Id
	@Column(name = "coupon_id")
	private String couponId;
	
	private Float value;

	public CouponDict() {
		super();
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CouponDict [couponId=" + couponId + ", value=" + value + "]";
	}
	
	
}
