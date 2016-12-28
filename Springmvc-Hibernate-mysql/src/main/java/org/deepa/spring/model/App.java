package org.deepa.spring.model;

import java.util.List;

import org.deepa.spring.security.service.OrderServiceImpl;

public class App {

	public static void main(String[] args) {
		OrderServiceImpl impl=new OrderServiceImpl();
		/*impl.placeUserOrder(new Order("depu19@gmail.com","Deepa","Book"));
		impl.placeUserOrder(new Order("jocnud@gmail.com","Shaz","Book"));*/
		
	/*	List<Order> orders = impl.getAllOrders();
		System.out.println(orders.toString());*/
	}
	
}
