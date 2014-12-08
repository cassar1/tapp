package com.assign.services;

import java.util.ArrayList;

import interfaces.User_management;

import com.assign.models.*;

public class UserManagement implements User_management {
	public ArrayList<User> accounts = new ArrayList<User>();
	
	@Override
	public boolean add_user(User u) {
		accounts.add(u);
		return true;
	}

	@Override
	public User get_user(String username) {
		for(User u : accounts)
		{
			if(u.username.equals(username))
				return u;
		}
		return null;
	}

	@Override
	public User validate_login(String username, String pass) {
		for(User u : accounts)
		{
			if(u.username.equals(username) && u.password.equals(pass))
				return u;
		}
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increment_attempts(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void block_user(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_before() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test_after() {
		// TODO Auto-generated method stub
		
	}

}
