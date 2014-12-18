package com.assign.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import interfaces.User_management;

import com.assign.models.User;
import com.mysql.jdbc.Connection;

public class UserManagementDB implements User_management{
	public ArrayList<User> accounts = new ArrayList<User>();
	Session session;
	
	public UserManagementDB()
	{
		
		//System.out.println("here");
	}
	
	@Override
	public boolean add_user(User u) {
			session =  HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        //System.out.println("begin adding");
	        session.save(u);
	        session.getTransaction().commit();
	        //System.out.println("finish adding");
	        session.close();
		return true;
	}

	@Override
	public User get_user(String username) 
	{
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery(
					"select * from users u where u.username = :name")
					.addEntity(User.class)
					.setParameter("name", username);
					List result = query.list();
			User user = (User) result.get(0);

			session.getTransaction().commit();
			
			return user;
		}
		catch(Exception e)
		{
			//System.out.println("Exception" + e);
			return null;
		}
		finally
		{
			session.close();
		}
		
	}

	@Override
	public User validate_login(String username, String pass) {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			User user ;
			//System.out.print("username "+username+"  pass "+pass);
			Query query = session.createSQLQuery(
					"select * from users u where u.username = :name and u.password = :pass")
					.addEntity(User.class)
					.setParameter("name", username)
					.setParameter("pass", pass);
					List result = query.list();
			session.getTransaction().commit();
			if(result.size() > 0)
			{
				user = (User) result.get(0);
				return user;
			}
			else
			return null;
		}
		catch(Exception e)
		{
			System.out.println("Exception " + e);
			return null;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public boolean check_duplicate(String username) {
		for(User u : accounts)
		{
			if(u.username.equals(username))
				return true;
		}
		return false;
	}

	@Override
	public Integer get_user_id(String username) {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery(
					"select id from users where username = :name")
					.addEntity(User.class)
					.setParameter("name", username);
					List result = query.list();
			Integer id = (Integer) result.get(0);
			return id;
		}
		catch(Exception e)
		{
			return null;
		}
		finally
		{
			session.close();
		}
	}
	
	@Override
	public void increment_attempts(String username) 
	{
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			//System.out.println("incrementing");
			session.beginTransaction();
			Query query = session.createSQLQuery(
					"update users set login_attempts = (login_attempts + 1)  where username = :name")
					.addEntity(User.class)
					.setParameter("name", username);
			query.executeUpdate();
			//System.out.println("incrementing");
			session.getTransaction().commit();	
		}
		catch(Exception e)
		{
			System.out.println("exception "+e);
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public void reset(String username) {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery(
					"update users set login_attempts = 0,blocked = false, last_attempt = null  where username = :name")
					.addEntity(User.class)
					.setParameter("name", username);
			query.executeUpdate();
			session.getTransaction().commit();	
		}
		catch(Exception e)
		{
			System.out.println("exception "+e);
		}
		finally
		{
			session.close();
		}
		
	}

	@Override
	public void block_user(String username) {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery(
					"update users set login_attempts = 0, blocked = true, last_attempt = NOW()  where username = :name")
					.addEntity(User.class)
					.setParameter("name", username);
			query.executeUpdate();
			session.getTransaction().commit();	
		}
		catch(Exception e)
		{
			System.out.println("exception "+e);
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public void test_before() {
		session = HibernateUtil.getSessionFactory().openSession();
		User test_user1 = new User("freeAcc","12345678","John","Borg",
				"1992/08/25",1,"348334291014748","2017/05/01","123");
		User test_user2 = new User("premAcc","12345678","John","Borg",
				"1992/08/25",2,"348334291014748","2017/05/01","123");
		add_user(test_user1);
		add_user(test_user2);
	}

	@Override
	public void test_after() {
		// TODO Auto-generated method stub
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createSQLQuery(
					"delete from users where username in ('Jurgen','freeAcc','premAcc')")
					.addEntity(User.class);
			query.executeUpdate();
			session.getTransaction().commit();	
		}
		catch(Exception e)
		{
			System.out.println("exception "+e);
		}
		finally
		{
			session.close();
		}
	}
}
