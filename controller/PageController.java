package Asm_ps20667.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("home/shop-details")
	public String shop_details() {
		return "home/shop-details";
	}

	@RequestMapping("home/shoping-cart")
	public String shoping_cart() {
		return "home/shoping-cart";
	}

	@RequestMapping("home/blog-details")
	public String blog_details() {
		return "home/blog-details";
	}
}
