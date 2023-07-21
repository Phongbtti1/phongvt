package Asm_ps20667.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Asm_ps20667.model.Account;
import Asm_ps20667.model.Order;
import Asm_ps20667.model.OrderDetail;
import Asm_ps20667.repository.OrderDetailDAO;
import Asm_ps20667.service.CheckOutService;
import Asm_ps20667.service.ShoppingCartService;
import Asm_ps20667.utils.ParamService;
import Asm_ps20667.utils.SessionService;

@Controller
@RequestMapping("home")
public class CheckOutController {
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	ParamService paramService;
	
	@Autowired
	CheckOutService checkOutService;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@RequestMapping("checkout")
	public String checkout(Model model) {
		model.addAttribute("cart", shoppingCartService);
		return "home/checkout";
	}
	
	@RequestMapping("order-detail")
	public String orderdetail(Model model) {
		String address = paramService.getString("address", "");
		if(!shoppingCartService.getItems().isEmpty()) {
			if(address.equals("")) {
				return "redirect: home/checkout";
			}
			Account user = sessionService.get("user");
			Order order = checkOutService.order(user, address);
			List<OrderDetail> items = orderDetailDAO.findByOrderID(order.getId());
			model.addAttribute("order", order);
			model.addAttribute("items",items);
			return "home/order-detail";
		}
		return "redirect:/home/index";
	}
}
