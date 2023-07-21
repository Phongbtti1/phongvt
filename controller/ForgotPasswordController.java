package Asm_ps20667.controller;

import java.util.Optional;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Asm_ps20667.model.Account;
import Asm_ps20667.repository.AccountDAO;
import Asm_ps20667.serviceIplm.MailerServiceImpl;
import Asm_ps20667.utils.ParamService;
import Asm_ps20667.utils.SessionService;
import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("home")
public class ForgotPasswordController {

	@Autowired
	AccountDAO dao;
	@Autowired
	SessionService session;
	@Autowired
	ParamService paramService;
	@Autowired
	MailerServiceImpl mailer;
	@Autowired
	ServletContext app;
	
	@RequestMapping("forgot_password")
	public String index() {
		return "home/forgot_password";
	}
	
	@PostMapping("forgot_password")
	public String change(Model model) {
		String email = paramService.getString("email", "");
		String username = paramService.getString("username", "");
		String subject = "Send your Password!";
		String body = "Your Password: ";
		String password;
		String randomPassword = RandomString.make(6);
		
		try {
			Account user = dao.findById(username).get();
				if(!user.getEmail().equalsIgnoreCase(email)) {
					model.addAttribute("message", "Wrong Email!");
				}else {
					user.setPassword(randomPassword);
					dao.save(user);
					mailer.send(email, subject, body+randomPassword);
					model.addAttribute("message", "Please check your Email!");
				}
		} catch (Exception e) {
			model.addAttribute("message", "Account invalid!");
		}
		return "home/forgot_password";
	}
//	
//	@PostMapping("forgot-password")
//	public String forgotpass(Model model) {
//		String email = paramService.getString("email", "");
//		String username = paramService.getString("username", "");
//		String subject = "Send your Password!";
//		String body = "Your Password: ";
//		String password;
//		String randomPassword = RandomString.make(6);
//		Optional<Account> accOp = dao.findByUsername(username);
//		if(accOp.isPresent() && accOp.get().getEmail().equals(email)) {
//			try {
//				password = accOp.get().getPassword();
//				mailer.send(email, subject, body+password);
//				model.addAttribute("message", "Please check your Email!");
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}else {
//			model.addAttribute("error", "Invalid Email or Username!");
//		}
//		System.out.println(randomPassword);
//		return "home/forgot-password";
//	}
}
