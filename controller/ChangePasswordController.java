package Asm_ps20667.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Asm_ps20667.model.Account;
import Asm_ps20667.repository.AccountDAO;
import Asm_ps20667.utils.CookieService;
import Asm_ps20667.utils.ParamService;
import Asm_ps20667.utils.SessionService;

@Controller
@RequestMapping("home")
public class ChangePasswordController {

	@Autowired
	ParamService paramService;
	@Autowired
	AccountDAO accDAO;
	@Autowired
	SessionService sessionService;
	@Autowired
	CookieService cookieService;

	@RequestMapping("change-password")
	public String index() {
		return "home/change-password";
	}

	@PostMapping("change-password")
	public String change(Model model) {
		String username = paramService.getString("username", "");
		String password = paramService.getString("password", "");
		String newpassword= paramService.getString("newpassword", "");
		String confirmpassword= paramService.getString("confirmpassword", "");
		try {
			Account user = accDAO.findById(username).get();
				if(!user.getPassword().equals(password)) {
					model.addAttribute("message", "Sai mật khẩu!");
				}else {
					if(newpassword.equals(confirmpassword)) {
						user.setPassword(confirmpassword);
						accDAO.save(user);
						model.addAttribute("message", "Đổi mạt khẩu thành công!");
					}else {
						model.addAttribute("message", "Mật khẩu xác nhận phải giống mật khẩu mới!");
					}
				}
		} catch (Exception e) {
			model.addAttribute("message", "Tài khoản không tồn tại!");
		}
		return "home/change-password";
	}
}
