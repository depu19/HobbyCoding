package org.deepa.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS_TABLE")
public class OrdersEntity {

	@Id
	@Column(name="ID")
	private String Id;
	
	@Column(name="EMAIL")
	private String emailId;
	
	@Column(name="USERNAME")
	private String customerName;
	
	@Column(name="ITEM")
	private String item;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

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
	
	
}
