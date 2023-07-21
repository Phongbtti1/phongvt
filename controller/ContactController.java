package Asm_ps20667.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	@RequestMapping("home/contact")
	public String home(){
		return "home/contact";
	}
}
