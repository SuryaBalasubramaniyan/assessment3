package com.sapient.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sapient.model.*;
import com.sapient.dao.*;
@Service(value="userservice")
public class UserServiceImpl implements UserService {
	@Autowired
	 @Qualifier(value = "hibernateDAOImpl")
	private UserDao userDao;
	public  UserServiceImpl(@Qualifier(value = "hibernateDAOImpl")UserDao userDao) {
		this.userDao=userDao;
	}
	@Transactional
	public List<User> listAll() {
		System.out.println("List all users");
		return userDao.listAll();
	}
	@Transactional
	public User findById(long id) {
		System.out.println("User by id");
		return userDao.findById(id);
	}
	@Transactional
	public void insert(User user) {
		System.out.println("Insert user");
		userDao.insert(user);
	}
	@Transactional
	public void delete(long id) {
		System.out.println("Delete user");
		userDao.delete(id);
		
	}
	@Transactional
	public void update(long id, User user) {
		System.out.println("Update user");
		userDao.update(id,user);
		
	}
	public List<Post> findPostById(long id) {
		
		return userDao.findPostById(id);
	}

	public Post findPostByIdById(long id, long pid) {
		// TODO Auto-generated method stub
		return userDao.findPostByIdById(id,pid);
	}

	public void putPostById(long id, Post posts) {
		// TODO Auto-generated method stub
		userDao.putPostById(id,posts);
		
	}

}
	
