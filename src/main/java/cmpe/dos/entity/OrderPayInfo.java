package cmpe.dos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_PAY_INFO")
public class OrderPayInfo {
	
	@Id
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "card_num")
	private String cardNum;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "cardholder_name")
	private String cardholderName;
	
	@Column(name = "expire_date")
	private Date date;

	public OrderPayInfo(Integer orderId, String cardNum, String cardType, String cardholderName, Date date) {
		super();
		this.orderId = orderId;
		this.cardNum = cardNum;
		this.cardType = cardType;
		this.cardholderName = cardholderName;
		this.date = date;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderPayInfo [orderId=" + orderId + ", cardNum=" + cardNum + ", cardType=" + cardType
				+ ", cardholderName=" + cardholderName + ", date=" + date + "]";
	}
	
}
