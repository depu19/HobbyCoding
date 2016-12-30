package org.deepa.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.deepa.spring.entity.OrdersEntity;
import org.deepa.spring.entity.UserDetailsEntity;

public interface UserOrderDao {

	public List<OrdersEntity> getAllOrders() throws SQLException;
	
	public void saveOrder(OrdersEntity order);
	
	public void saveUser(UserDetailsEntity user);
}
