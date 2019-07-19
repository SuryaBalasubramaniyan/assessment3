package com.sapient.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.model.*;

@Repository("hibernateDAOImpl")
public class HibernateUserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	
	public List<User> listAll() {
		System.out.println("Hello within Dao");
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User ").list();
	}
	
	public User findById(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	public void insert(User user) {
		 System.out.println("Within dao insert");
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(user);
	}
	
	public void delete(long id) {
		 Session session = sessionFactory.getCurrentSession();
	     User user = session.byId(User.class).load(id);
	        session.delete(user);
		
	}
	
	public void update(long id, User user) {
		// TODO Auto-generated method stub
		
	}
	public List<Post> findPostById(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(User.class, id).getPost();
	}

	public Post findPostByIdById(long id, long pid) {
		// TODO Auto-generated method stub
		List<Post> plist= sessionFactory.getCurrentSession().get(User.class, id).getPost();
		for(Post p: plist)
		{
			if(p.getId()==pid)
				return p;
		}
			return null;
	}

	public void putPostById(long id, Post post) {
		// TODO Auto-generated method stub
		
	}

}
