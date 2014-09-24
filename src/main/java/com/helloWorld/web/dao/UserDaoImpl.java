package com.helloWorld.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.helloWorld.web.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
		
	}

	public void addUser(User user) {
		getCurrentSession().save(user);		
	}

	public User getUser(String username) {
		User user = (User)getCurrentSession().get(User.class, username);
		return user;
	}

	public void updateUser(User user) {
		User usertoUpdate = getUser(user.getUsername());
		usertoUpdate.setPassword(user.getPassword());
		usertoUpdate.setRole(user.getRole());
		getCurrentSession().update(user);
	}

	public void deleteUser(String username) {
		User user = getUser(username);
		if(user!=null){
			getCurrentSession().delete(user);
		}
	}
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List users =getCurrentSession().createQuery("from User").list();
		return users;
	}
	

}
