package implementation;

import java.util.ArrayList;

import interfaces.Betting_management;

public class BettingManagement implements Betting_management {
	ArrayList<Bet> all_bets = new ArrayList<Bet>();
	
	@Override
	public ArrayList<Bet> get_all_bets(User user) {
		String name = user.getUser();
		ArrayList<Bet> bets = new ArrayList<Bet>();
		for(Bet b : all_bets)
		{
			if(b.getUsername().equals(name))
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
	public boolean validate_bet(User user, int risk_level, int amount) {
		int type = user.getType();
		if(type == 0)
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
	public int get_number_bets(User user) {
		String username = user.getUser();
		int num_of_bets = 0;
		for(Bet b : all_bets)
		{
			if(b.getUsername().equals(username))
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
			if(b.getUsername().equals(username))
				total += b.getAmount();
		}
		return total;
	}

}
