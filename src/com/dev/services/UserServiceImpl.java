package com.dev.services;

import com.dev.beans.User;
import com.dev.dao.JDBCImpl;
import com.dev.dao.UserDAO;

public class UserServiceImpl implements UserService{
	
	UserDAO db=new JDBCImpl(); 
	@Override
	public Boolean createProfile(User user) {
		return db.createProfile(user); 
	}

	@Override
	public User searchUser(Integer userId) {
		return db.searchUser(userId);
	}

	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
		return db.updatePassword(userId, oldPassword, newPassword);
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		return db.deleteUser(userId, password);
	}

	@Override
	public User loginUser(Integer userId, String passwd) {
		return db.loginUser(userId, passwd);
	}

}
