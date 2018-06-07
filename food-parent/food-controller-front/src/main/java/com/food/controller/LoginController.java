package com.food.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.food.pojo.User;
import com.food.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("regUser")
	public String regUser(HttpServletRequest req) {
		String uemail = req.getParameter("uemail");
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		String message = "";
		if (!(uemail.equals(""))) {
			if (!(uname.equals(""))) {
				if (!(password.equals(""))) {
					if (uemail.indexOf('@') != -1 && uemail.indexOf('.') > uemail.indexOf('@')) {
						User user1 = userService.selectUserByEmail(uemail);
						if (user1 == null) {
							User user = new User();
							String img = "upload/img12.png";
							user.setUemail(uemail);
							user.setUname(uname);
							user.setPassword(password);
							user.setHeadportrait(img);
							userService.insertUser(user);
							message = "注册成功,已跳转到登陆界面!";
							req.getSession().setAttribute("message", message);
							return "login";

						} else {
							message = "该邮箱已被注册";
							req.getSession().setAttribute("message", message);
							return "reg";
						}
					} else {
						message = "邮箱不合法";
						req.getSession().setAttribute("message", message);
						return "reg";
					}
				} else {
					message = "密码不能为空";
					req.getSession().setAttribute("message", message);
					return "reg";
				}
			} else {
				message = "昵称不能为空";
				req.getSession().setAttribute("message", message);
				return "reg";
			}
		} else {
			message = "邮箱不能为空";
			req.getSession().setAttribute("message", message);
			return "reg";
		}
	}
	
	@RequestMapping("loginUser")
	public String loginUser(HttpServletRequest req){
		String uemail = req.getParameter("uemail");
		String password = req.getParameter("password");
		String message = "";
		if (!(uemail.equals(""))) {
			if (!(password.equals(""))) {
				User user1 = userService.selectUserByEmail(uemail);
				if (user1 != null) {
					if(user1.getPassword().equals(password)){
						message = "登陆成功";
						req.getSession().setAttribute("message", message);
						req.getSession().setAttribute("is_login", "is");
						req.getSession().setAttribute("user", user1);
						return "active";
					}else{
						message = "密码错误";
						req.getSession().setAttribute("message", message);
						return "login";
					}
				}else{
					message = "邮箱不存在";
					req.getSession().setAttribute("message", message);
					return "login";
				}
			}else{
				message = "密码不能为空";
				req.getSession().setAttribute("message", message);
				return "login";
			}
		}else{
			message = "邮箱不能为空";
			req.getSession().setAttribute("message", message);
			return "login";
		}
	}

}
