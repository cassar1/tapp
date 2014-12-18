package test.assign.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.junit.Assert;


import org.junit.Test;

import com.assign.models.User;

import net.sourceforge.czt.modeljunit.AllRoundTester;
import net.sourceforge.czt.modeljunit.FsmModel;
import net.sourceforge.czt.modeljunit.GreedyTester;
import net.sourceforge.czt.modeljunit.Tester;
import net.sourceforge.czt.modeljunit.VerboseListener;
import net.sourceforge.czt.modeljunit.Action;



public class TestVM implements FsmModel{
	SiteStates page;//string to determine the state 
	private BettingSite sut;
	User u;
	boolean registered = false;
	public static ArrayList<String> timer = new ArrayList<String>();

	@Override
	public Object getState() {
		return page;
	}
	
	public TestVM()
	{
		
	}

	@Override
	public void reset(boolean arg0) {
		u = new User(generateRandomString(), "testpassword", "Joe", "Borg", "11/08/1990", 1, "378282246310005", "05/2017", "123");
		sut = new BettingSite(timer);
		sut.logout();
		registered = false;
		page = SiteStates.LOGIN;
		System.out.println("-----------------------------------------------------------------------------------------------------------");
	}

	public boolean chooseRegisterGuard()
	{
		return getState().equals(SiteStates.LOGIN) && !registered;
	}
	@Action
	public void chooseRegister()
	{
		sut.chooseRegister();
		page = SiteStates.REGISTRATION;
		Assert.assertEquals(page, sut.getPage());
	}
	
	
	public boolean inputRegistrationDetailsGuard()
	{
		return getState().equals(SiteStates.REGISTRATION);

	}
	@Action
	public void inputRegistrationDetails()
	{
		int type = 0;
		double num = Math.random();
		if(num>=0.25 && num <=1.0)
		{
			type = 1;
		}
		else 
		{
			type = 2;
		}
		u.setType(type);
		sut.inputRegistrationDetails(u);
		page = SiteStates.LOGIN;
		registered = true;
		Assert.assertEquals(page, sut.getPage());
	}
	public boolean inputLoginDetailsGuard()
	{
			return getState().equals(SiteStates.LOGIN) && registered; 
	}
	@Action
	public void inputLoginDetails()
	{
		String username = "";
		String password = "";
		SiteStates state = null;
		double num = Math.random();
		if(num>=0.25 && num <=1.0)
		{
			username = u.getUsername();
			password = "testpassword";
			state = SiteStates.READY_TO_BET;
		}
		else 
		{
			username = u.getUsername();
			password = "xys";
			state = SiteStates.LOGIN;
		}
		System.out.println(username + " " + password);
		sut.inputLoginDetails(username,password);
		page = state;
		Assert.assertEquals(page, sut.getPage());
	}
	
	public boolean inputBetGuard()
	{
			return getState().equals(SiteStates.READY_TO_BET);
	}

	@Action
	public void inputBet()
	{
		String amount;
		Random rand = new Random();
		int randomNum = 0;
		if(true)
			 randomNum = rand.nextInt((6 - 1) + 1) + 1;
		/*else
			randomNum = rand.nextInt((2000 - 100) + 1) + 100;*/
		sut.inputBetDetails(1,randomNum+"");
		page = SiteStates.READY_TO_BET;
		Assert.assertEquals(page, sut.getPage());
	}
	public boolean logoutGuard()
	{
		double num = Math.random();
		if(num>=0.5 && num <=1.0)
			return getState().equals(SiteStates.READY_TO_BET);
		else
			return false;
	}
	@Action
	public void logout()
	{
		sut.logout();
		page = SiteStates.LOGIN;
		Assert.assertEquals(page, sut.getPage());
	}
	
	@Test
	public void test()
	{	
		/*Tester t = new AllRoundTester(new TestVM());
		t.addListener(new VerboseListener());
		t.generate(1);
		t.buildGraph();*/
		
		GreedyTester t = new GreedyTester(new TestVM());
		t.addListener(new VerboseListener());
		t.generate(10);
		t.buildGraph();
		System.out.println("Finished");
	}
	
	
	public static String generateRandomString(){
		String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * CHARACTERS.length());
            salt.append(CHARACTERS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
