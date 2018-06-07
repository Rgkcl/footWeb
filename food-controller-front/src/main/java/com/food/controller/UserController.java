package com.food.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.food.pojo.User;
import com.food.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public static boolean isMobileNO(String tel) {
        String telRegex = "[1][3578]\\d{9}";
        if (TextUtils.isEmpty(tel)) {
            return false;
        } else
            return tel.matches(telRegex);
    }
	
	@RequestMapping("user_save")
	public String userSave(HttpServletRequest req,String uname,String pro,String intro,String sex,String inpprovince,String inpcity,String inpuarea) {
		String message = null;
		User user = (User) req.getSession().getAttribute("user");
		if(!uname.equals("")){
				CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(req.getSession().getServletContext());
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
		        // 取得request中的所有文件名
		        Iterator<String> iter = multiRequest.getFileNames();
		        while (iter.hasNext()) {
		        	MultipartFile file = multiRequest.getFile(iter.next());
		        	if (file != null) {
		        	String myFileName = file.getOriginalFilename();
		        	if (myFileName.trim() != "") {
		        	int uid = user.getUid();
		            String fileName = uid + file.getOriginalFilename();
		        	String path = "D:/foodWeb/food-controller-front/src/main/webapp/WEB-INF/upload/"+fileName;
		        	user.setHeadportrait("upload/"+fileName);
		            File localFile = new File(path);
		            try {
						file.transferTo(localFile);
					} catch (Exception e) {
					}}}
		        }
			user.setUname(uname);
			user.setPro(pro);
			user.setIntro(intro);
			user.setUprovince(inpprovince);
			user.setUcity(inpcity);
			user.setUarea(inpuarea);
			if(sex!=null){
		    	user.setSex(sex);
		    }
			userService.updateUser(user);
			req.getSession().setAttribute("user", user);
			return "mem";
		}else{
			message = "昵称不能为空";
			req.getSession().setAttribute("message", message);
			return "mem";
		}
	}
	
	@RequestMapping("bindingTel")
	public String bindingTel(String tel,HttpServletRequest req) {
		String message = null;
		boolean isPhoneNum = userService.isPhoneNum(tel);
		if(isPhoneNum){
			User user = (User) req.getSession().getAttribute("user");
			if(user.getTel()!=null){
				if(user.getTel().equals(tel)){
					return "phone-bind-done";
				}
			}
				boolean isPhone = userService.isPhone(tel);
				if(!isPhone){
					user.setTel(tel);
					userService.updateUser(user);
					req.getSession().setAttribute("binding", "已绑定");
					return "phone-bind-done";
				}else{
					message = "该手机号已被绑定过";
					req.getSession().setAttribute("message", message);
					return "Phone";
				}
			
		}else{
			message = "请输入正确的手机号";
			req.getSession().setAttribute("message", message);
			return "Phone";
		}
	}
	
	@RequestMapping("updatePass")
	public String updatePass(String password1,String password2,String password3,HttpServletRequest req) {
		String message = null;
		if(!(password1.equals("")||password2.equals("")||password3.equals(""))){
			User user = (User) req.getSession().getAttribute("user");
		    String oldPass = user.getPassword();
		    if(oldPass.equals(password1)){
		    	if(password2.equals(password3)){
		    		if(password2.length()>=6){
		    			user.setPassword(password2);
		    			userService.updateUser(user);
		    			req.getSession().setAttribute("user", user);
		    			message = "密码修改成功";
		    			req.getSession().setAttribute("message", message);
		    			return "mem";
		    		}else{
		    			message = "请重新输入，密码最少6位";
						req.getSession().setAttribute("message", message);
						return "pwd";
		    		}
		    	}else{
		    		message = "两次新密码输入不一致";
					req.getSession().setAttribute("message", message);
					return "pwd";
		    	}
		    }else{
		    	message = "原始密码错误";
				req.getSession().setAttribute("message", message);
				return "pwd";
		    }
		}else{
			message = "密码不能为空";
			req.getSession().setAttribute("message", message);
			return "pwd";
		}
	}

}
