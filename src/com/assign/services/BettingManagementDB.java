package com.assign.services;

import interfaces.Betting_management;
import interfaces.User_management;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.assign.models.Bet;
import com.assign.models.User;

public class BettingManagementDB implements Betting_management{
	
	Session session;
	
	public BettingManagementDB()
	{
			session =  HibernateUtil.getSessionFactory().openSession();
	
	}
		

	@Override
	public boolean place_bet(Bet bet) {
		session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
        System.out.println("begin adding");
        session.save(bet);
        session.getTransaction().commit();
        System.out.println("finish adding");
        session.close();
        return true;
	}

	@Override
	public int validate_bet(User user, int risk_level, int amount) {
		int type = user.getType();
		if(type == 1)//free
		{//1 good, 2 risk level, 3, bad amount, 4 exceed number of bets
			if(risk_level != 1)
				return 2;
			else if(amount > 5)
				return 3;
			else if(get_number_bets(user) > 2)	
				return 4;
			else
				return 1;
		}
		else
		{//0 cumulativ eamount exceeded
			int total = amount + get_total_amount(user);
			if(total > 5000)
				return 0;
			else
				return 1;
		}

	}

	@Override
	public int get_number_bets(User user) 
	{
		List<Bet> result;
		int num_bets = 0;
		try
		{
			session =  HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			Query query = session.createSQLQuery(
					"select * from bets where user = :name")
					.addEntity(Bet.class)
					.setParameter("name", user.getUser());
					 result =  query.list();
			session.getTransaction().commit();	 
			 if(result.size() > 0)
			 {
				 for(int i = 0 ; i < result.size();i++)
				 {
					 num_bets++;
				 }
				 return num_bets;
			 }
			return 0; 
		}
		catch(Exception e)
		{
			return 0;
		}
		finally
		{
			session.close();
		}

	}
	//amount of money
	@Override
	public int get_total_amount(User user) {
		List<Bet> result;
		int amount = 0;
		try
		{
			session =  HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			Query query = session.createSQLQuery(
					"select * from bets where user = :name")
					.addEntity(Bet.class)
					.setParameter("name", user.getUser());		 
			result =  query.list();
			
			 if(result.size() > 0)
			 {
				 for(int i = 0 ; i < result.size();i++)
				 {
					 amount = amount + result.get(i).getAmount();
				 }
				 return amount;
			 }
			return 0; 
		}
		catch(Exception e)
		{
			return 0;
		}
		finally
		{
			session.close();
		}
	}
	@Override
	public List<Bet> get_all_bets(User user) {
		List<Bet> result = new ArrayList<Bet>();
		try
		{
			session =  HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction(); 
			System.out.println("name " + user.getUser());
			Query query = session.createSQLQuery(
					"Select * from bets where user = :name")
					.addEntity(Bet.class)
					.setParameter("name", user.getUser());
			result =  query.list();
			System.out.println("result " + result.size());
			session.getTransaction().commit();		 
			return result;
			
		}
		catch(Exception e)
		{
			System.out.println("Excpetion " + e );
			return null;
		}
		finally
		{
			session.close();
		}
	}
	
}
