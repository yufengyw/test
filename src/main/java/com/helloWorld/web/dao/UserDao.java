package com.helloWorld.web.dao;

import java.util.List;

import com.helloWorld.web.model.User;

public interface UserDao {
	public void addUser(User user);
	public User getUser(String username);
	public void updateUser(User user);
	public void deleteUser(String username);
	public List<User> getUsers();
	

}
