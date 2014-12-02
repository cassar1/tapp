package com.assign.models;

public class Bet {
	public int id;
	String user;
	int risk_level;//0 low, 1 medium, 2 high
	int amount;
	
	public Bet(){}
	public Bet(String user,int risk,int amount)
	{
		this.user = user;
		this.risk_level = risk;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getRisk_level() {
		return risk_level;
	}
	public void setRisk_level(int risk_level) {
		this.risk_level = risk_level;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
