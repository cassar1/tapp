package interfaces;

import java.util.ArrayList;
import java.util.List;

import com.assign.models.*;

public interface Betting_management {
	public List<Bet> get_all_bets(User user);
	public boolean place_bet(Bet bet);
	public int validate_bet(User user, int risk_level, int amount);
	public int get_number_bets(User user);//returns number of bets user has
	public int get_total_amount(User user);//returns amount of all bets
}
