package Asm_ps20667.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("home")
public class BlogController {
	@RequestMapping("blog")
	public String home(){
		return "home/blog";
	}
}
