package com.food.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.UserMapper;
import com.food.pojo.User;
import com.food.service.UserService;

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
