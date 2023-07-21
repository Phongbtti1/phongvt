package Asm_ps20667.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Asm_ps20667.utils.SessionService;

@Controller
@RequestMapping("home")
public class LogoutController {
	@Autowired
	SessionService sessionService;
	
	@RequestMapping("logout")
	public String logout() {
		sessionService.remove("user");
		return "redirect:/home/index";
	}
}
