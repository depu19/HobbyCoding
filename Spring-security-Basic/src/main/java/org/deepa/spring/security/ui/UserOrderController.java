package org.deepa.spring.security.ui;

import java.sql.SQLException;
import java.util.List;

import org.deepa.spring.model.Order;
import org.deepa.spring.security.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class UserOrderController {
	
	@Autowired(required=true)
	@Qualifier(value="userOrderService")
	private UserOrderService userOrderService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView getIndex()
	{
		ModelAndView model=new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView receiveOrder()
	{
		Order order = new Order();
		ModelAndView model=new ModelAndView("createorder");
		model.addObject(order);
		model.addObject("success",false);
		return model;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView addOrderToCart(@ModelAttribute("order") Order order, BindingResult errors)
	{
		userOrderService.placeUserOrder(order);
		ModelAndView model=new ModelAndView("index");
		model.addObject("success",true);
		return model;
	}

	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView getAllOrders()
	{
		ModelAndView model=new ModelAndView("vieworder");
		List<Order> orderList = null;
		try {
			orderList = userOrderService.getAllOrders();
			model.addObject("orderList", orderList);
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		return model;
	}
	
	public UserOrderService getUserOrderService() {
		return userOrderService;
	}

	public void setUserOrderService(UserOrderService userOrderService) {
		this.userOrderService = userOrderService;
	}
	
	

}
