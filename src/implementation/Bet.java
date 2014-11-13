package implementation;

public class Bet {
	String username;
	int risk_level;//0 low, 1 medium, 2 high
	int amount;
	
	public Bet(String user)
	{
		this.username = user;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
