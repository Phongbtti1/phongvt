package Asm_ps20667.controller.admin;

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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Asm_ps20667.model.Category;
import Asm_ps20667.repository.CategoryDAO;


@Controller
@RequestMapping("admin")
public class CategoryController {
	
	@Autowired
	CategoryDAO dao;
	
	@RequestMapping("/category")
	public String paginate(Model model,	@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
		Page<Category> page = dao.findAll(pageable);
		int currentPage =1;
		int totalItems = page.getNumberOfElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("page", page);
		return "admin/categoryList";
	}
	
	@RequestMapping("/categoryControl")
	public String control(Model model) {
		Category item = new Category();
		model.addAttribute("item", item);
		return "admin/categoryControl";
	}
	
	
	@RequestMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Category item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/categoryControl";
	}
	
	@RequestMapping("/category/create")
	public String create(Model model, Category item) {
		dao.save(item);
		model.addAttribute("message", "Insert successfully");
		return "redirect:/admin/categoryControl";
	}
	
	@RequestMapping("/category/delete/{id}")
	public String create(@PathVariable("id") String id) {
		dao.deleteById(id);
		return "redirect:/admin/category";
	}
	
	@RequestMapping("/category/update")
	public String update(Model model, Category item) {
		dao.save(item);
		model.addAttribute("message", "Update successfully");
		return "redirect:/admin/category/edit/" + item.getId();
	}
	
}
