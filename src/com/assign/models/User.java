package com.assign.models;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public  class User {
	public int id;
	public String username;
	public String password;
	public String name;
	public String surname;
	public String dob;
	
	public int account_type;//0 free, 1 premium
	public String credit_card;
	public String expiry_date;
	public String cvv;
	public int login_attempts;
	public boolean blocked;
	public Timestamp last_attempt;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	public String getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public int getLogin_attempts() {
		return login_attempts;
	}

	public void setLogin_attempts(int login_attempts) {
		this.login_attempts = login_attempts;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Date getLast_attempt() {
		return last_attempt;
	}

	public void setLast_attempt(Timestamp last_attempt) {
		this.last_attempt = last_attempt;
	}
	public User(String user, String pass,String first_name,String last_name,
	String dob,int type,String credit_card_num,String expiry_date,String cvv)
	{
		this.username = user;
		this.password = pass;
		this.name = first_name;
		this.surname = last_name;
		this.dob = dob;
		this.account_type = type;
		this.credit_card = credit_card_num;
		this.expiry_date = expiry_date;
		this.cvv = cvv;
	}
	
	public User(String user,String pass)
	{
		this.username = user;
		this.password = pass;		
	}
	public User()
	{
		
	}
	
	public boolean[] validate_user()
	{
		boolean[] validate = new boolean[8];
		validate[0] = validate_name(name);
		validate[1] = validate_name(surname);
		validate[2] = validate_name(username);
		validate[3] = validate_password(password);
		validate[4] = validate_dob(dob);
		
		validate[5] = validate_creditnum(credit_card);
		validate[6] = validate_expiry(expiry_date);
		if(validate[4] && validate[6])
			change_dates();
		validate[7] = validate_cvv(cvv);
		for(int i = 0; i < validate.length;i++)
			System.out.println(validate[i]);
		return validate;
	}
	public boolean validate_password(String pass)
	{
		if(pass.length() >= 8)
			return true;
		else
			return false;
	}
	public  boolean validate_name(String inp)
	{
		Pattern p = Pattern.compile("[a-zA-Z ]");
	
		boolean is_good = p.matcher(inp).find();
		if(inp.isEmpty() || inp == null)
			return false;
		else if(!is_good)
			return false;
		else
			return true;
	}
	public boolean validate_dob(String dob)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		
		Date current = cal.getTime();
		System.out.println("current "+ current); 
		try 
		{
			Date d1 = dateFormat.parse(dob);
			System.out.println("input date: " + d1);
			
			long milli = Math.abs(current.getTime() - d1.getTime());
			int days = (int)(milli/(1000*60*60*24));
			System.out.println("days " + days);
			double years = days/365;
			System.out.println("years " + years);
			if(years >= 18)
				return true;
			else 
				return false;
		} catch (ParseException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean validate_creditnum(String num)
	{
		return luhnTest(num);
	}
    public static boolean luhnTest(String number){
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }

	public boolean validate_expiry(String expiry_date)
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
		Calendar cal = Calendar.getInstance();
		System.out.println(); 
		Date current = cal.getTime();
		try 
		{
			Date d1 = dateFormat.parse(expiry_date);
			//System.out.println(d1);
			
			if(d1.getTime() > current.getTime())
				return true;
			else 
				return false;
		} catch (ParseException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public int getType() {
		return account_type;
	}
	public void setType(int type) {
		this.account_type = type;
	}
	
	public String getUser() {
		return username;
	}
	public void setUser(String user) {
		this.username = user;
	}
	
	public boolean validate_cvv(String cvv)
	{
		if (cvv.length() == 3)
		{
				return isNumeric(cvv);
		}
		return false;
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

	public void change_dates()
	{
		//to get date in form yyyy-mm-dd
		String[] dates = dob.split("/");
		String new_date = dates[2] + "/" + dates[1] + "/" + dates[0];
		dob = new_date;
		dates = expiry_date.split("/");
		new_date = dates[1] + "/" + dates[0] + "/01";
		expiry_date = new_date;
	}
}
