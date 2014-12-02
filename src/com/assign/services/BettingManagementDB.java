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
		session.beginTransaction();
        System.out.println("begin adding");
        session.save(bet);
        session.getTransaction().commit();
        System.out.println("finish adding");
        return true;
	}

	@Override
	public boolean validate_bet(User user, int risk_level, int amount) {
		int type = user.getType();
		if(type == 0)//free
		{
			if(risk_level != 0 || amount > 5 || get_number_bets(user) > 2)
				return false;
			else
				return true;
		}
		else
		{
			int total = amount + get_total_amount(user);
			if(total > 5000)
				return false;
			else
				return true;
		}

	}

	@Override
	public int get_number_bets(User user) 
	{
		List<Bet> result;
		int num_bets = 0;
		try
		{
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

	}
	//amount of money
	@Override
	public int get_total_amount(User user) {
		List<Bet> result;
		int amount = 0;
		try
		{
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
	}
	@Override
	public List<Bet> get_all_bets(User user) {
		List<Bet> result = new ArrayList<Bet>();
		try
		{
			session.beginTransaction(); 
			System.out.println("name " + user.getUser());
			Query query = session.createSQLQuery(
					"Select * from bets where user = :name")
					.addEntity(Bet.class)
					.setParameter("name", user.getUser());
			result =  query.list();
			System.out.println("result " + result.size());
			session.getTransaction().commit();		 
			
			 if(result.size() > 0)
			 {
				 return result;
			 }
			return null; 
		}
		catch(Exception e)
		{
			System.out.println("Excpetion " + e );
			return null;
		}
	}
	
}
