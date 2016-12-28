package org.deepa.spring.security.service;

import org.deepa.spring.dao.UserOrderDao;
import org.deepa.spring.entity.Address;
import org.deepa.spring.entity.UserDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userOrderDao")
	private UserOrderDao userOrderDao;

	public void saveUserDetails(UserDetailsEntity user) {
		Address address=new Address();
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setStreet("5th cross");
		address.setPincode("560094");
		user.setAddress(address);
		Address homeAddress=new Address();
		homeAddress.setCity("Kolkata");
		homeAddress.setState("WestBengal");
		homeAddress.setStreet("2th cross");
		homeAddress.setPincode("560192");
		user.setHomeAddress(homeAddress);
		userOrderDao.saveUser(user);
		System.out.println("User persisted to DB");
	}
	
}
