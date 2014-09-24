package com.helloWorld.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloWorld.web.dao.UserDao;
import com.helloWorld.web.model.User;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public void addUser(User user) {
		userDao.addUser(user);
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userDao.getUser(username);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);		
	}

	public void deleteUser(String username) {
		userDao.deleteUser(username);
		
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

}
