package com.xuantujava.DTO;

import javax.persistence.Column;

public class TransactionDTO extends AbstractDTO<TransactionDTO> {

	private Long amount;
	private String orderId;
	private Long description;
	private Long userId;

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getDescription() {
		return description;
	}

	public void setDescription(Long description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
