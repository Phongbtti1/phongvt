package Asm_ps20667.controller.shopgrid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Asm_ps20667.model.Product;
import Asm_ps20667.repository.ProductDAO;
@Controller
@RequestMapping("home")
public class shop_gridController {
	@Autowired
	ProductDAO proDAO;
		
	@RequestMapping("shop1")
	public String paginate1(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1000", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop1";
	}
	
	@RequestMapping("shop2")
	public String paginate2(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1001", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop2";
	}
	@RequestMapping("shop3")
	public String paginate3(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1002", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop3";
	}
	@RequestMapping("shop4")
	public String paginate4(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1003", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop4";
	}
	@RequestMapping("shop5")
	public String paginate5(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1004", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop5";
	}
	@RequestMapping("shop6")
	public String paginate6(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1005", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop6";
	}
	@RequestMapping("shop7")
	public String paginate7(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1006", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop7";
	}
	@RequestMapping("shop8")
	public String paginate8(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1007", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop8";
	}
	@RequestMapping("shop9")
	public String paginate9(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1008", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop9";
	}
	@RequestMapping("shop10")
	public String paginate10(Model model, @RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = proDAO.findByCategory("1009", pageable);
		int currentPage = 1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		return "home/shop10";
	}
}


