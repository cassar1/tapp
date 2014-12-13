package test.assign.models;

import java.util.Random;

import org.junit.Assert;


import org.junit.Test;

import com.assign.models.User;

import net.sourceforge.czt.modeljunit.AllRoundTester;
import net.sourceforge.czt.modeljunit.FsmModel;
import net.sourceforge.czt.modeljunit.Tester;
import net.sourceforge.czt.modeljunit.VerboseListener;
import net.sourceforge.czt.modeljunit.Action;


public class TestVM implements FsmModel{
	SiteStates page;//string to determine the state 
	private BettingSite sut;
	
	@Override
	public Object getState() {
		return page;
	}

	@Override
	public void reset(boolean arg0) {
		// TODO Auto-generated method stub
		sut = new BettingSite();
		page = SiteStates.LOGIN;
	}

	public boolean inputRegistrationDetailsFreeGuard()
	{
		double num = Math.random();
		if(num>=0.25 && num <1)
			return getState().equals(SiteStates.REGISTRATION);
		else
			return false;
	}

	public boolean inputRegistrationDetailsPremGuard()
	{
		double num = Math.random();
		if(num>=0.0 && num <0.25)
			return getState().equals(SiteStates.REGISTRATION);
		else
			return false;
	}
	@Action
	public void inputRegistrationDetailsFree()
	{
		User user = new User("Jurgen","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		inputRegistrationDetails(user);
	}
	@Action
	public void inputRegistrationDetailsPrem()
	{
		User user = new User("Jurgen","12345678","John","Abela",
				"25/04/1992",1,"348334291014748","05/2017","123");
		inputRegistrationDetails(user);
	}
	
	public void inputRegistrationDetails(User user)
	{
		sut.inputRegistrationDetails(user);
		page = SiteStates.LOGIN;
		System.out.println("SUT PAGE AFTER REGISTER" + sut.getPage());
		Assert.assertEquals(sut.getPage(), page);
	}
	
	public boolean inputLoginDetailsGoodGuard()
	{
		double num = Math.random();
		if(num>=0.25 && num <1.0)
			return getState().equals(SiteStates.LOGIN);
		else 
			return false;
	}

	public boolean inputLoginDetailsBadGuard()
	{
		double num = Math.random();
		if(num>=0.0 && num <0.25)
			return getState().equals(SiteStates.LOGIN);
		else
			return false;
	}
	@Action
	public void inputLoginDetailsGood()
	{
		inputLoginDetails("Chris","portelli", SiteStates.READY_TO_BET);
	}
	@Action
	public void inputLoginDetailsBad()
	{
		inputLoginDetails("Chris","xvy",SiteStates.LOGIN);
	}
	public void inputLoginDetails(String username,String pass, SiteStates state)
	{
		sut.inputLoginDetails(username,pass);
		page = state;
		Assert.assertEquals(sut.getPage(), page);
	}
	/*@Action
	public void choosePlaceBet()
	{
		sut.placeBet();
		page = SiteStates.BETTING;
		Assert.assertEquals(sut.getPage(), page);
	}*/
	
	public boolean inputBetFreeGuard()
	{
		return getState().equals(SiteStates.READY_TO_BET);
	}
	
	public boolean inputBetPremGuard()
	{
		return getState().equals(SiteStates.READY_TO_BET);
	}
	@Action
	public void inputBetFree()
	{
		Random rand = new Random();
	    int randomNum = rand.nextInt((5 - 1) + 1) + 1;
	    inputBet(1,""+randomNum);
	}
	@Action
	public void inputBetPrem()
	{
		Random rand = new Random();
	    int randomNum = rand.nextInt((2000 - 100) + 1) + 100;
	    inputBet(1,""+randomNum);
	}
	public void inputBet(int risk, String amount)
	{
		sut.inputBetDetails(risk,amount);
		page = SiteStates.READY_TO_BET;
		Assert.assertEquals(sut.getPage(), page);
	}
	@Action
	public void logout()
	{
		sut.logout();
		page = SiteStates.LOGIN;
		Assert.assertEquals(sut.getPage(), page);
	}

	
	@Test
	public void test()
	{
		Tester t = new AllRoundTester(new TestVM());
		t.addListener(new VerboseListener());
		t.generate(1);
		t.buildGraph();
	}

}
