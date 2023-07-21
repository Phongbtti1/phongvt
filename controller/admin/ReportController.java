package Asm_ps20667.controller.admin;

import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Asm_ps20667.model.Order;
import Asm_ps20667.model.ReportCategory;
import Asm_ps20667.model.Top10;
import Asm_ps20667.model.TopCustomer;
import Asm_ps20667.repository.AccountDAO;
import Asm_ps20667.repository.OrderDAO;
import Asm_ps20667.repository.OrderDetailDAO;
import Asm_ps20667.repository.ProductDAO;
import Asm_ps20667.utils.CookieService;
import Asm_ps20667.utils.ParamService;
import Asm_ps20667.utils.SessionService;
import Asm_ps20667.model.RevenueReport;

@RequestMapping("admin")
@Controller
public class ReportController {

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
	OrderDAO orderDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@RequestMapping("bestsaler")
	public String bestSaler(Model model) {
		Pageable pageable = PageRequest.of(0, 10000); 
		Page<Top10> topList = orderDetailDAO.getTop10(pageable);
		model.addAttribute("topList", topList);
		return ("admin/bestsaler");
	}
	
	@RequestMapping("topcustomer")
	public String topCustomer(Model model) {
		List<TopCustomer> topCustomer = accDAO.getTopAccount();
		model.addAttribute("topCustomer", topCustomer);
		return ("admin/topcustomer");
	}
	
	@RequestMapping("reportcategory")
	public String inventory(Model model) {
		List<ReportCategory> items = proDAO.getReportCategory();
		model.addAttribute("items", items);
		return "admin/reportcategory";
	}
	
	@RequestMapping("reportOrderByDate")
	public String reportOrderByDate(Model model) {
		return "admin/reportOrderByDate";
	}
	
	
	@PostMapping("reportOrderByDate")
	public String reportByDate(Model model, @RequestParam("p") Optional<Integer> p) {
		Date firstDate = paramService.getDate("firstDate", "MM-dd-yyyy");
		Date lastDate = paramService.getDate("lastDate", "MM-dd-yyyy");
		sessionService.set("firstDate", firstDate);
		sessionService.set("lastDate", lastDate);
		Pageable pageable = PageRequest.of(p.orElse(0), 1000);
		Page<Order> page = orderDAO.findOrderByDate(firstDate, lastDate, pageable);
		model.addAttribute("page", page);
		return "admin/reportOrderByDate";
	}
	
	
	@RequestMapping("revenuereport")
	public String RevenueReport(Model model) {
		List<RevenueReport> items = orderDetailDAO.getRevenueByCategory();
		model.addAttribute("items", items);
		return "admin/revenuereport";
	}
	
}
