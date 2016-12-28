package com.ayan.bussiness;

import java.util.List;

import com.ayan.user.User;

public interface UserAdminSvc {
	
	public Long createUser(User user);
	
	public User getUser(Long userId);
	
	public List<User> getUsers();
	
	public void updateUser(User user);
	
	public void deleteUser(Long userId);

}
