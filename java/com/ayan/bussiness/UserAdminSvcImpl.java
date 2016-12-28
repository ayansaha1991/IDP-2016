package com.ayan.bussiness;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayan.user.User;

@Repository
public class UserAdminSvcImpl implements UserAdminSvc {
    
	private static final Log log = LogFactory.getLog(UserAdminSvcImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory ;  
	
	public Long createUser(User user){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		user.setUsername(user.getUsername());
		session.save(user);
		
		transaction.commit();
		session.close();
		log.info("User has been created ");
		
		return user.getUserId();
	}

	@Override
	public User getUser(Long userId) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, userId);
		
		transaction.commit();
		session.close();
		log.info("User found  " + user.getUserId());
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		
		transaction.commit();
		session.close();
		log.info("Users found  " + users);
		
		return users;
	}

	@Override
	public void updateUser(User user) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user1 = session.get(User.class, user.getUserId());
		
		user1.setUsername(user.getUsername());
		
		transaction.commit();
		session.close();
		log.info("User updated  " + user1.getUserId());
		
	}

	@Override
	public void deleteUser(Long userId) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, userId);
		session.delete(user);
		
		transaction.commit();
		session.close();
		log.info("User updated  " + user.getUserId());
		
	}
}
