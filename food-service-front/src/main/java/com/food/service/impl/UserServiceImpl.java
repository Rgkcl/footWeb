package com.food.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.UserMapper;
import com.food.pojo.User;
import com.food.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
@Autowired
UserMapper userMapper;

public static boolean isMobileNO(String tel) {
    String telRegex = "[1][3578]\\d{9}";
    if (TextUtils.isEmpty(tel)) {
        return false;
    } else
        return tel.matches(telRegex);
}

	public User selectUserByEmail(String uemail) {
		return userMapper.selectUserByEmail(uemail);
	}

	public int insertUser(User user) {
		return userMapper.insert(user);
	}

	public int updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	public boolean isPhoneNum(String tel) {
		if(isMobileNO(tel)){
			return true;
		}else{
			return false;
		}
	}
	
	//判断电话号码是否已经被注册
	public boolean isPhone(String tel){
		User user = userMapper.selectUserByTel(tel);
		if(user==null){
			return false;
		}else{
			return true;
		}
	}

}
