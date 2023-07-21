package Asm_ps20667.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Asm_ps20667.model.Order;
import Asm_ps20667.model.OrderDetail;
import Asm_ps20667.repository.OrderDAO;
import Asm_ps20667.repository.OrderDetailDAO;
import Asm_ps20667.utils.CookieService;
import Asm_ps20667.utils.ParamService;
import Asm_ps20667.utils.SessionService;

@Controller
@RequestMapping("admin")
public class OrderDetailController {
	
	
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;
	@Autowired
	OrderDetailDAO orderDetailDAO;
	@Autowired
	OrderDAO orderDAO; 
	

	@RequestMapping("orderDetail")
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
		
		Pageable pageable = PageRequest.of(p.orElse(0), 999);
		Page<OrderDetail> page = orderDetailDAO.findByOrder(id, pageable);
		int currentPage =1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "admin/orderDetailList";
	}

}
