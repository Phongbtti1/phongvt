package Asm_ps20667.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Asm_ps20667.model.Order;
import Asm_ps20667.model.OrderDetail;
import Asm_ps20667.model.Product;
import Asm_ps20667.repository.OrderDAO;
import Asm_ps20667.repository.OrderDetailDAO;
import Asm_ps20667.utils.ParamService;


@RequestMapping("/home")
@Controller
public class MyOrderController {

	@Autowired
	OrderDAO orderDAO; 
	
	@Autowired
	OrderDetailDAO 	orderDetailDAO;
	
	@Autowired
	ParamService paramService;
	
	@RequestMapping("/myorder")
	public String myorder(Model model) {
		String username = paramService.getString("username", "");
		List<Order> items = orderDAO.findOrderByAccount(username);
		model.addAttribute("items", items);
		System.out.println(username);
		return "home/myorder";
	}
	
	@RequestMapping("/myOrderDetail")
	public String locBrand(Model model, @RequestParam("id") long id, @RequestParam("p") Optional<Integer> p) {
		Order order = new Order();
		List<Order> orders = orderDAO.findAll();
		for (Order ord : orders) {
			if (ord.getId() == id) {
				order = ord;
				break;
			}
		}	
		model.addAttribute("ord", order);
		Pageable pageable = PageRequest.of(p.orElse(0), 1000);
		Page<OrderDetail> page = orderDetailDAO.findByOrder(id, pageable);
		int currentPage =1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/myorderdetail";
	}
}
