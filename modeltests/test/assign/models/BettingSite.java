package test.assign.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;

import junit.framework.Assert;

import com.assign.models.User;


public class BettingSite {
	Connection con;
	Connection.Response resp;
	Document doc;
	String sessionId ;
	public BettingSite()
	{
		try {
			con = Jsoup.connect("http://localhost:8080/3222Assign/login.html");
			resp = con.execute();
			sessionId = resp.cookie("JSESSIONID");
			doc = con.get();
		} catch (IOException e) {
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
	//input registration details then set the page returned in this object
	public void inputRegistrationDetails(User u)
	{
		try {
			doc = Jsoup.connect("http://localhost:8080/3222Assign/registration.html")
					.data("username_field",u.getUser())
				    .data("password_field", u.getPassword())
				    .data("first_name",u.getName())
				    .data("last_name", u.getSurname())
				    .data("dob",u.getDob())
				    .data("type", u.getType()+"")
				    .data("credit_card_num",u.getCredit_card())
				    .data("expiry_date", u.getExpiry_date())
				    .data("cvv", u.getCvv())
				    .post();
			//System.out.println(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//input login details then set the page returned in this object
	public void inputLoginDetails(String user,String pass)
	{
		try {
			doc = con.data("username_field", user)
				    .data("password_field", pass)
				    .cookie("JSESSIONID", sessionId)
				    .post();
			
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
	}
	public void placeBet() {
			
	}
	public void inputBetDetails(int risk, String amount) {
		try {
			doc = Jsoup.connect("http://localhost:8080/3222Assign/betting.html")
					.data("risk_level", ""+risk)
				    .data("amount", "2")
				    .cookie("JSESSIONID", sessionId)
				    .post();
			//System.out.println(doc);
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
	
	public static void main(String[] args) {
		BettingSite a = new BettingSite();
		System.out.println("Before logging in");
		a.inputLoginDetails("Chris", "portelli");
		System.out.println("After logging in");
		System.out.println("Before placing bet");
		a.inputBetDetails(1,"153");
		a.getPage();
	}
	
	/*public void submittingForm() throws Exception {
	    final WebClient webClient = new WebClient();
	    // Get the first page
	    final HtmlPage page1 = webClient.getPage("http://some_url");
	    // Get the form that we are dealing with and within that form, 
	    // find the submit button and the field that we want to change.
	    final HtmlForm form = page1.getFormByName("myform");

	    final HtmlSubmitInput button = form.getInputByName("submitbutton");
	    final HtmlTextInput textField = form.getInputByName("userid");

	    // Change the value of the text field
	    textField.setValueAttribute("root");

	    // Now submit the form by clicking the button and get back the second page.
	    final HtmlPage page2 = button.click();

	    webClient.closeAllWindows();
	}*/
	
	
}
