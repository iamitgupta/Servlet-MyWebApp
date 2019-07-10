    
package com.dev.dao;

import com.dev.beans.User;

public interface UserDAO {
	public Boolean createProfile(User user);
	public User searchUser(Integer userId);
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword);
	public Boolean deleteUser(Integer userId, String password);
	public User loginUser(Integer userId,String passwd);
}	