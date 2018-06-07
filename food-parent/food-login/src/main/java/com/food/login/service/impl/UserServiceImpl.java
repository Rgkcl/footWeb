package com.food.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.UserMapper;
import com.food.login.service.UserService;
import com.food.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	
@Autowired
UserMapper userMapper;

	public User selectUserByEmail(String uemail) {
		return userMapper.selectUserByEmail(uemail);
	}

	public int insertUser(User user) {
		return userMapper.insert(user);
	}

}
