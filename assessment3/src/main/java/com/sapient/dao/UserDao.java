package com.sapient.dao;

import java.util.List;

import com.sapient.model.*;

public interface UserDao {
	public List<User> listAll();
	public User findById(long id);
	public void insert(User user);
	public void delete(long id);
	public void update(long id, User user);
	public List<Post> findPostById(long id);
	public Post findPostByIdById(long id,long pid);
	public void putPostById(long id, Post post ) ;
}
