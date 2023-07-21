package Asm_ps20667.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("admin/index")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("admin/index2")
	public String index2() {
		return "admin/index2";
	}
}
