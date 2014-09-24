package com.helloWorld.web.service;

import java.util.List;

import com.helloWorld.web.model.User;

public interface UserService {
	public void addUser(User user);
	public User getUser(String username);
	public void updateUser(User user);
	public void deleteUser(String username);
	public List<User> getUser();
}
