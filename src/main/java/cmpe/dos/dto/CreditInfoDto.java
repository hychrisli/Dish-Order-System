package cmpe.dos.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

public class CreditInfoDto {

	@JsonInclude(value = NON_NULL)
    @ApiModelProperty(required = true)
	private String cardNum;

	@JsonInclude(value = NON_NULL)
	private String cardType;
	
	@JsonInclude(value = NON_NULL)
	private String cardholderName;
	
	@JsonInclude(value = NON_NULL)
	private Date date;

	public CreditInfoDto() {
		super();
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
		return "CreditInfoDto [cardNum=" + cardNum + ", cardType=" + cardType + ", cardholderName=" + cardholderName
				+ ", date=" + date + "]";
	}
	
	
}
