package org.deepa.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.deepa.spring.entity.OrdersEntity;
import org.deepa.spring.entity.UserDetailsEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("userOrderDao")
public class UserOrderDaoImpl implements UserOrderDao{
	
	private final String username="root";
	
	private final String driver="com.mysql.jdbc.Driver";
	
	private final String url="jdbc:mysql://localhost:3306/sakila";
	
	private final String password="password";
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session()
	{
		System.out.println("*********************sessionFactory.getCurrentSession()"+sessionFactory.getCurrentSession());
		return sessionFactory.getCurrentSession();
	}
	
	
	public List<OrdersEntity> getAllOrders() throws SQLException {
		Session session = null;
		List<OrdersEntity> orderList = null;
		try{
		 session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrdersEntity");
		orderList = (List<OrdersEntity>) query.list();
		session.getTransaction().commit();
		System.out.println(orderList.size());
		}
		catch(DataAccessException ex)
		{
			System.out.println("exception while fetching list of users");
		}
		finally {
			session.close();
		}
		return orderList;
	}
	
	
	public void saveOrder(OrdersEntity order) {
		System.out.println("Saving Order to DB");
		Session session = null;
		try{
		 session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		}
		catch(DataAccessException ex)
		{
			System.out.println("Exception while Saving Order to DB"+ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		
	}
	
	public void saveUser(UserDetailsEntity user) {
		System.out.println("Saving Order to DB");
		Session session = null;
		try{
		 session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		}
		catch(DataAccessException ex)
		{
			System.out.println("Exception while Saving Order to DB"+ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	 

}
