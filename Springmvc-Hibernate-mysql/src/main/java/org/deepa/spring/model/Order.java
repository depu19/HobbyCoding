package org.deepa.spring.model;

import java.io.Serializable;

public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7986620641440235895L;
	
	public Order(){
		
	}

	public Order(String emailId, String customerName, String item) {
		super();
		this.emailId = emailId;
		this.customerName = customerName;
		this.item = item;
	}

	private String emailId;
	
	private String customerName;
	
	private String item;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order [emailId=" + emailId + ", customerName=" + customerName + ", item=" + item + "]";
	}
	
	

}
