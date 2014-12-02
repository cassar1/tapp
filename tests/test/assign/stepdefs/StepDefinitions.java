package test.assign.stepdefs;

import com.assign.models.User;
import com.assign.services.UserManagement;
import com.assign.services.UserManagementDB;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class StepDefinitions {
	UserManagement manager;
	
	@Given("^I am a user trying to register$")
	public void I_am_trying_to_register() throws Throwable
	{
		manager = new UserManagement();
	}
	@When("^I register with (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
	public void I_register_with(String arg1,String arg2,String arg3,String arg4,String arg5,int arg6,String arg7,String arg8,String arg9) throws Throwable
	{
		User u = new User("Jurgen","12345678","Jurgen","Cassar","25/04/1994",0,"48334291014748","05/2017","123");
		boolean [] valid = u.validate_user();
		boolean valid_input = true;
		for(int i = 0; i < valid.length;i++)
		{
			if(valid[i] == false)
				valid_input = false;
		}
		if(valid_input)
			manager.add_user(u);
	}
	@Then("^I should get the result (.*)$")
	public void I_should_get_result(String arg1) throws Throwable
	{
		assertEquals(arg1,"true");
	}
}
