package cmpe.dos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEFAULT_PAYCARD")
public class DefaultPaycard {

	@Id
	private String username;
	
	@Column(name = "card_num")
	private String cardNum;

	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "cardholder_name")
	private String cardholderName;
	
	@Column(name = "expire_date")
	private Date date;	
		
	public DefaultPaycard() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "DefaultPaycard [username=" + username + ", cardNum=" + cardNum + ", cardType=" + cardType
				+ ", cardholderName=" + cardholderName + ", date=" + date + "]";
	}
	
}
