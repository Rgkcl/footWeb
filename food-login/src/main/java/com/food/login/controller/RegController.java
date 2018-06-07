package com.food.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.login.service.UserService;
import com.food.pojo.User;

@Controller
public class RegController {
	
    @Autowired
    private UserService userService;
	
	@RequestMapping("regUser")
	public String regUser(HttpServletRequest req) {
		String uemail = req.getParameter("uemail");
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		String message = "";
		if(!(uemail.equals(""))){
			if(!(uname.equals(""))){
				if(!(password.equals(""))){
					if (uemail.indexOf('@') != -1 && uemail.indexOf('.') > uemail.indexOf('@')) {
						User user1 = userService.selectUserByEmail(uemail);
						if(user1==null){
							User user = new User();
							user.setUemail(uemail);
							user.setUname(uname);
							user.setPassword(password);
							userService.insertUser(user);
							message = "注册成功,已跳转到登陆界面!";
							req.getSession().setAttribute("message", message);
							return "login";
							
						}else{
							message = "该邮箱已被注册";
							req.getSession().setAttribute("message", message);
							return "reg";
						}
					} else {
						message = "邮箱不合法";
						req.getSession().setAttribute("message", message);
						return "reg";
					}
				}else{
					message = "密码不能为空";
					req.getSession().setAttribute("message", message);
					return "reg";
				}
			}else{
				message = "昵称不能为空";
				req.getSession().setAttribute("message", message);
				return "reg";
			}
		}else{
			message = "邮箱不能为空";
			req.getSession().setAttribute("message", message);
			return "reg";
		}
	}
}
