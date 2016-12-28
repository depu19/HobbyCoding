package org.deepa.spring.security.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.deepa.spring.dao.UserOrderDao;
import org.deepa.spring.entity.OrdersEntity;
import org.deepa.spring.entity.UserDetailsEntity;
import org.deepa.spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements UserOrderService{
	
	
	@Autowired
	@Qualifier("userOrderDao")
	private UserOrderDao userOrderDao;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;

	public void placeUserOrder(Order order) {
		UserDetailsEntity user = new UserDetailsEntity();
		user.setUsername(order.getCustomerName());
		userServiceImpl.saveUserDetails(user);
		saveOrder(order);
		
	}

	public List<Order> getAllOrders() throws SQLException {
		List<OrdersEntity> entity = userOrderDao.getAllOrders();
		List<Order> orderList=new ArrayList<Order>();
		for(OrdersEntity order:entity)
		{
			Order orderVo=new Order();
			orderVo.setCustomerName(order.getCustomerName());
			orderVo.setEmailId(order.getEmailId());
			orderVo.setItem(order.getItem());
			orderList.add(orderVo);
		}
		return orderList;
	}

	public void saveOrder(Order order) {
		OrdersEntity entity = new OrdersEntity();
		entity.setId(UUID.randomUUID().toString());
		entity.setCustomerName(order.getCustomerName());
		entity.setEmailId(order.getEmailId());
		entity.setItem(order.getItem());
		userOrderDao.saveOrder(entity);
		System.out.println("Order persisted to DB");
		
	}
}
