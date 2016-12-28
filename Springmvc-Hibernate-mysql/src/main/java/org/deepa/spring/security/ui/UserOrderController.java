package org.deepa.spring.security.ui;

import java.sql.SQLException;

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
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView receiveOrder(@ModelAttribute("order") Order order,BindingResult errors)
	{
		ModelAndView model=new ModelAndView("createorder");
		model.addObject(order);
		return model;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView addOrderToCart(@ModelAttribute("order") Order order, BindingResult errors)
	{
		userOrderService.placeUserOrder(order);
		ModelAndView model=new ModelAndView("createorder");
		model.addObject("success","Order ");
		return model;
	}

	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView getAllOrders(@ModelAttribute("order") Order order,BindingResult errors)
	{
		ModelAndView model=new ModelAndView("vieworder");
		try {
			model.addObject(userOrderService.getAllOrders());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
