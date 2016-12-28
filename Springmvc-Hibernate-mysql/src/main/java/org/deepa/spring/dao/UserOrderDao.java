package org.deepa.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.deepa.spring.entity.OrdersEntity;

public interface UserOrderDao {

	public List<OrdersEntity> getAllOrders() throws SQLException;
	
	public void saveOrder(OrdersEntity order);
}
