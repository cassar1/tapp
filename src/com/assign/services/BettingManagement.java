package com.assign.services;

import java.util.ArrayList;

import interfaces.Betting_management;
import com.assign.models.*;

public class BettingManagement implements Betting_management {
	ArrayList<Bet> all_bets = new ArrayList<Bet>();
	
	@Override
	public ArrayList<Bet> get_all_bets(User user) {
		String name = user.getUser();
		ArrayList<Bet> bets = new ArrayList<Bet>();
		for(Bet b : all_bets)
		{
			if(b.getUser().equals(name))
				bets.add(b);
		}
		return bets;
	}

	@Override
	public boolean place_bet(Bet bet) {
		all_bets.add(bet);
		return true;
	}

	@Override
	public int validate_bet(User user, int risk_level, int amount) {
		int type = user.getType();
		if(type == 1)//free
		{
			if(risk_level != 0 || amount > 5 || get_number_bets(user) > 2)
				return 0;
			else
				return 1;
		}
		else
		{
			int total = amount + get_total_amount(user);
			if(total > 5000)
				return 0;
			else
				return 1;
		}

	}

	@Override
	public int get_number_bets(User user) {
		String username = user.getUser();
		int num_of_bets = 0;
		for(Bet b : all_bets)
		{
			if(b.getUser().equals(username))
				num_of_bets++;
		}
		return num_of_bets;
	}

	@Override
	public int get_total_amount(User user) {
		String username = user.getUser();
		int total = 0;
		for(Bet b : all_bets)
		{
			if(b.getUser().equals(username))
				total += b.getAmount();
		}
		return total;
	}

}
