package test.assign.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;







import com.assign.models.User;


public class BettingSite{
	Connection con;
	Connection.Response resp;
	Document doc;
	String sessionId ;
	long start_time;
	long end_time;
	long diff;
	ArrayList<String> timer;
	public BettingSite(ArrayList<String> timer)
	{
		this.timer = timer;
		try {
			con = Jsoup.connect("http://localhost:8080/3222Assign/login.html");
			resp = con.execute();
			sessionId = resp.cookie("JSESSIONID");
			doc = con.get();
			
		} catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
	}
	public void getPageContent() throws IllegalStateException, IOException
	{
		
	}
	//return current state or page
	public SiteStates getPage()
	{
		String title = doc.title();
		//System.out.println(title);
		switch(title){
		case "Login": return SiteStates.LOGIN;
		case "Betting": return SiteStates.READY_TO_BET;
		case "Register": return SiteStates.REGISTRATION;
		default: return SiteStates.BETTING;
		}
		
	}
	public void chooseRegister() {
		try {
			doc = Jsoup.connect("http://localhost:8080/3222Assign/registration.html").get();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR4");
		}
	}
	//input registration details then set the page returned in this object
	public void inputRegistrationDetails(User u)
	{
		try {
			start_time = System.currentTimeMillis(); 
			System.out.println("start time "+start_time);
			doc = Jsoup.connect("http://localhost:8080/3222Assign/registration.html")
					.data("username_field",u.getUsername())
				    .data("password_field", u.getPassword())
				    .data("first_name",u.getName())
				    .data("last_name", u.getSurname())
				    .data("dob",u.getDob())
				    .data("type", u.getType()+"")
				    .data("credit_card_num",u.getCredit_card())
				    .data("expiry_date", u.getExpiry_date())
				    .data("cvv", u.getCvv())
				    .post();
			end_time = System.currentTimeMillis();
			System.out.println("end time "+end_time);
			diff = (end_time-start_time);
			timer.add("Register," + diff);
			System.out.println("----------------------------------------------------------Registration Time " + ((end_time-start_time)));
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	//input login details then set the page returned in this object
	public void inputLoginDetails(String user,String pass)
	{
		
		try {
			start_time = System.currentTimeMillis();  
			doc =  Jsoup.connect("http://localhost:8080/3222Assign/login.html")
					.data("username_field", user)
				    .data("password_field", pass)
				    .cookie("JSESSIONID", sessionId)
				    .post();
			end_time = System.currentTimeMillis(); 
			diff = (end_time-start_time);
			timer.add("Login," + diff);

		} catch (IOException e) {
			System.out.println("Error " + e);
		}
	}
	
	public void inputBetDetails(int risk, String amount) {
		try {
			 start_time = System.currentTimeMillis(); ;
			doc = Jsoup.connect("http://localhost:8080/3222Assign/betting.html")
					.data("risk_level", ""+risk)
				    .data("amount", "2")
				    .cookie("JSESSIONID", sessionId)
				    .post();
			end_time = System.currentTimeMillis(); ;
			diff = (end_time-start_time);
			timer.add("Bet," + diff);
			System.out.println("----------------------------------------------------------place Bet Time " + ((end_time-start_time)/1000000));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void logout() {
		try {
			doc = Jsoup.connect("http://localhost:8080/3222Assign/logout.html").get();
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
		
	}
	
	/*public static void main(String[] args) {
		BettingSite a = new BettingSite();
		System.out.println("Before logging in");
		a.inputLoginDetails("Chris", "portelli");
		System.out.println("After logging in");
		System.out.println("Before placing bet");
		a.inputBetDetails(1,"153");
		a.getPage();
	}*/
	
	
}
