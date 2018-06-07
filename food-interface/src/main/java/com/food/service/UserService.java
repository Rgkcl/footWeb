package com.food.service;


import com.food.pojo.User;

public interface UserService {
	
	public User selectUserByEmail(String uemail);
	
	//判断电话号码的格式是否正确
	public boolean isPhoneNum(String tel);
	
	//判断电话号码是否已经被注册
	public boolean isPhone(String tel);
	
	public int insertUser(User user);
	
	public int updateUser(User user);

}
