package com.assign.models;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UserLogin {
	String username;
	int login_counter;
	boolean logged_in;
	Date block_time;
	boolean is_blocked;
	
	public UserLogin()
	{}

	public UserLogin(String name, boolean login)
	{
		this.username = name;
		this.logged_in = login;
		Calendar cal = Calendar.getInstance();
		block_time = cal.getTime();
    	login_counter = 0;
    	is_blocked = false;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLogin_counter() {
		return login_counter;
	}
	public void setLogin_counter(int login_counter) {
		this.login_counter = login_counter;
	}
	public boolean isLogged_in() {
		return logged_in;
	}
	public void setLogged_in(boolean logged_in) {
		this.logged_in = logged_in;
	}
	public Date getBlock_time() {
		return block_time;
	}
	public void setBlock_time(Date block_time) {
		this.block_time = block_time;
	}
	public boolean isIs_blocked() {
		return is_blocked;
	}
	public void setIs_blocked(boolean is_blocked) {
		this.is_blocked = is_blocked;
	}
	public void increment_counter()
	{
		login_counter++;
	}
	public boolean login()
	{
		if(login_counter < 3)
		{
			logged_in = true;
			return true;
		}else
		{
			logged_in = false;
			return false;
		}
	}
	public Date get_time()
	{
		return block_time;
	}
	public int getFailedTimes()
	{
		return login_counter;
	}
	public void block()
	{
		is_blocked = true;
	}
	public void unblock()
	{
		is_blocked = false;
	}
	public boolean is_blocked()
	{
		return is_blocked;
	}
}
