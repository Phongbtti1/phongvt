package Asm_ps20667.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Asm_ps20667.model.Product;
import Asm_ps20667.model.Top10;
import Asm_ps20667.repository.AccountDAO;
import Asm_ps20667.repository.OrderDetailDAO;
import Asm_ps20667.repository.ProductDAO;
import Asm_ps20667.utils.CookieService;
import Asm_ps20667.utils.ParamService;
import Asm_ps20667.utils.SessionService;

@Controller
@RequestMapping("home")
public class HomeController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;
	@Autowired
	AccountDAO accDAO;	
	
	@Autowired
	ProductDAO proDAO;
	
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@RequestMapping("index")
	public String home(Model model){
		Pageable pageable = PageRequest.of(0, 10); 
		Page<Top10> topList = orderDetailDAO.getTop10(pageable);
		List<Product> wmList = proDAO.findByCategoryHome("0000");
		model.addAttribute("WMitems", wmList);
		List<Product> mList = proDAO.findByCategoryHome("1000");
		model.addAttribute("Mitems", mList);
		model.addAttribute("topList", topList);

		return "home/index";
	}
}
