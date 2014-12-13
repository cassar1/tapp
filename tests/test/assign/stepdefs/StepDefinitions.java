package test.assign.stepdefs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import test.assign.pageobjects.BettingPo;
import test.assign.pageobjects.LoginPo;
import test.assign.pageobjects.Register;

import com.assign.models.User;
import com.assign.services.UserManagement;
import com.assign.services.UserManagementDB;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class StepDefinitions {
	WebDriver browser;
	Register reg;
	LoginPo log;
	BettingPo betting;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
		browser.get("http://localhost:8080/3222Assign/");
		reg = new Register(browser);
		reg.setUp();
	
	}
	
	@Given("^I am a user trying to register$")
	public void I_am_trying_to_register() throws Throwable
	{
		//setUp();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
		browser.get("http://localhost:8080/3222Assign/registration.html");
	}
	/*@When("^I register with (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
	public void I_register_with(String arg1,String arg2,String arg3,String arg4,String arg5,int arg6,String arg7,String arg8,String arg9) throws Throwable
	{
		reg = new Register(browser);
		reg.input_details();

	}*/
	@When("^I register providing  correct information$")
	public void I_register_with() throws Throwable
	{
		reg = new Register(browser);
		reg.input_details("Jurgen","12345678","Jurgen","Cassar","25/04/1994","0","371449635398431","05/2017","123");
		reg.submit_btn();
	}
	@Then("^I should be told that the registration was successful$")
	public void I_should_get_result() throws Throwable
	{
		String msg = reg.is_successful();
		assertEquals("Registration was successful", msg);
		browser.quit();
	}
	
	@Given("^I am a user trying to register with incorrect data$")
	public void I_am_a_user_trying_to_register_with_incorrect_data() throws Throwable {
		browser = new ChromeDriver();
		browser.get("http://localhost:8080/3222Assign/registration.html");
	}

	@When("^I fill in a form with correct data$")
	public void I_fill_in_a_form_with_correct_data() throws Throwable {
		reg = new Register(browser);
		reg.input_details("Jurgen","12345678","Jurgen","Cassar","25/04/1994","0","371449635398431","05/2017","123");
	}

	@When("^I change the (.*) field to have incorrect input (.*)$")
	public void I_change_field_to_have_incorrect_input(String field,String input) throws Throwable {
	    System.out.println("fieldname        -------"+field);
		reg.edit_field(field, input);
		reg.submit_btn();
	}

	@Then("^I should be told that the data in (.*) is incorrect$")
	public void I_should_be_told_that_the_data_in_cvv_is_incorrect(String field) throws Throwable {
		String msg = reg.unsuccessful_message(field);
		String [] incorrect_messages = {"Name","Last Name","Dob","credit card num","expiry date"};
		String incorrect_message = "";
		switch(field)
		{
			case "first_name": incorrect_message = "Name";
								break;
			case "last_name": incorrect_message = "Last Name";
								break;
			case "dob": incorrect_message = "Dob";
								break;
			case "credit_card_num": incorrect_message = "credit card num";
								break;
			case "expiry_date": incorrect_message = "expiry date";
								break;
	
		}
		boolean contains = false;
		if(msg.contains(incorrect_message))
			contains = true;
		assertTrue(contains);
		browser.quit();
	}
	

	@Given("^I am a user with a free account$")
	public void I_am_a_user_with_a_free_account() throws Throwable {
		browser = new ChromeDriver();
		browser.get("http://localhost:8080/3222Assign/login.html");
		log = new LoginPo(browser);
		log.login("Jurgen","12345678");
		betting = new BettingPo(log.browser);
	}

	/*@When("^I try to place a bet of 5 euros$")
	public void I_place_bet_5_e() throws Throwable {
		betting.placeBet("1", "5");
	}*/

	@Then("^I should be told the bet was successfully placed$")
	public void I_should_be_told_that_the_bet_was_placed_successfully() throws Throwable 
	{
		String message = betting.check_success();
		boolean placed_success = false;
		if(message.contains("successfully"))
			placed_success=true;
		assertTrue(placed_success);	
		
	}
	@Then("^I should be told that I have reached the maximum number of bets$")
	public void I_should_be_told_that_I_have_reached_the_maximum_number_of_bets() throws Throwable {
		String message = betting.check_success();
		boolean placed_success = true;
		if(message.contains("maximum"))
			placed_success=false;
		assertFalse(placed_success);	
		browser.quit();
	}

	@Given("^I am a user with a premium account$")
	public void I_am_a_user_with_a_premium_account() throws Throwable {
		browser = new ChromeDriver();
		browser.get("http://localhost:8080/3222Assign/login.html");
		log = new LoginPo(browser);
		log.login("premAcc","12345678");
		betting = new BettingPo(log.browser);
	}

	@When("^I try to place a bet of (\\d+) euros$")
	public void I_try_to_place_a_bet_of_euros(int arg1) throws Throwable {
		betting.placeBet("1", ""+arg1);
	}

	@Then("^I should be told that I have reached the maximum cumulative betting amount$")
	public void I_should_be_told_that_I_have_reached_the_maximum_cumulative_betting_amount() throws Throwable {
		String message = betting.check_success();
		boolean placed_success = true;
		if(message.contains("cumulative"))
			placed_success=false;
		assertFalse(placed_success);	
		browser.quit();
	}

	@Given("^I am a user who has not yet logged on$")
	public void I_am_a_user_who_has_not_yet_logged_on() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
	}
	
	@When("^I try to access the betting screen$")
	public void When_I_try_to_access_the_betting_screen() throws Throwable{
		//the user doesn't have a session
		browser.get("http://localhost:8080/3222Assign/betting.html");
		log = new LoginPo(browser);
	}
	
	@Then("^I should be refused access$")
	public void I_should_be_refused_access() throws Throwable {
		String message = log.getMessage();
		boolean access_denied = false;
		if(message.equals("Access denied"))
			access_denied = true;
		assertTrue(access_denied);	
		browser.quit();
	}
	
	@Given("^I am a free-account user$")
	public void I_am_a_user_with_a_free_account2() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
		browser.get("http://localhost:8080/3222Assign/login.html");
		log = new LoginPo(browser);
		log.login("Jurgen","12345678");
		betting = new BettingPo(log.browser);
	}
	
	@When("^I try to place a (.*) bet of 5 euros")
	public void I_try_to_place_a_bet_of_5_euros(String risklevel) throws Throwable {
		betting.placeBet(risklevel, "5");
	}

	@Then("^I should be (.*) to bet")
	public void I_should_be_to_bet(String expected) throws Throwable {
		String message = betting.check_success(); //free accounts can only place low risk bets
		boolean allowed = true;
		boolean messageAllowed = true;
		switch(expected){
			case "allowed": allowed = true; break;
			case "not allowed": allowed = false; break;
		}
		if (message.contains("free accounts can only place low risk bets"))
			messageAllowed = false;
		
		assertEquals(messageAllowed, allowed);	
	}
	
	@After
	public void tearDown() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
		browser.get("http://localhost:8080/3222Assign/");
		reg = new Register(browser);
		reg.tearDown();
		browser.quit();
	}
}
