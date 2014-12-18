package test.assign.unittests;

import static org.junit.Assert.*;
import com.assign.models.Bet;
import com.assign.services.BettingManagement;
import com.assign.models.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
public class BettingTests {

	BettingManagement betManager;
	@Mock
	User user;
	@Mock
	Bet bet;
	@Before
	public void setUp() throws Exception {
		betManager = new BettingManagement();
		user = Mockito.mock(User.class);
		bet = Mockito.mock(Bet.class);
	}

	
	@Test
	public void test_place_bet() {
		//test that when a bet is added, size of arraylist increases
		Mockito.when(user.getUser()).thenReturn("Jurgen");
		Bet bet = new Bet("Jurgen",1,4);
		betManager.place_bet(bet);
		assertEquals(1,betManager.get_all_bets(user).size());
	}
	@Test
	public void test_all_bet() {
		//test that all bets of a user are returned
		User test = Mockito.mock(User.class);
		Mockito.when(test.getUser()).thenReturn("Chris");
		Mockito.when(user.getUser()).thenReturn("Jurgen");
		Bet bet = new Bet("Jurgen",1,4);
		Bet bet2 = new Bet("Chris",1,4);
		betManager.place_bet(bet);
		betManager.place_bet(bet2);
		assertEquals(1,betManager.get_all_bets(user).size());
	}
	
	@Test
	public void test_bet_numbers() {
		//test that all bets of a user are returned
		//Test condition if(b.getUsername().equals(username)) where names are not equal
		
		User test = Mockito.mock(User.class);
		Mockito.when(test.getUsername()).thenReturn("Chris");
		Mockito.when(user.getUsername()).thenReturn("Jurgen");
		Bet bet = new Bet("Jurgen",1,4);
		Bet bet1 = new Bet("Chris",1,4);
		betManager.place_bet(bet);
		betManager.place_bet(bet1);
		assertEquals(1,betManager.get_number_bets(user));
	}
	
	
	@Test
	public void test_validate_bet() {
		//testing when user tries risk level low with amount <6
		Mockito.when(user.getType()).thenReturn(1);
		assertEquals(1,betManager.validate_bet(user, 1, 5));
	}
	@Test
	public void test_validate_bet1() {
		//testing when user tries risk level medium with amount <6
		Mockito.when(user.getType()).thenReturn(1);
		assertEquals(2,betManager.validate_bet(user, 2, 5));
	}
	@Test
	public void test_validate_bet2() {
		//testing when user tries risk level low with amount >5
		Mockito.when(user.getType()).thenReturn(1);
		assertEquals(3,betManager.validate_bet(user, 1, 500));
	}
	@Test
	public void test_validate_bet3() {
		//testing when user tries risk level medium with amount >5
		Mockito.when(user.getType()).thenReturn(1);
		assertEquals(2,betManager.validate_bet(user, 2, 500));
	}
	@Test
	public void test_validate_bet4() {
		//testing when free user already has 3 bets
		Mockito.when(user.getUsername()).thenReturn("Jurgen");
		Mockito.when(user.getType()).thenReturn(1);
		Mockito.when(bet.getUser()).thenReturn("Jurgen");
		betManager.place_bet(bet);
		betManager.place_bet(bet);
		betManager.place_bet(bet);
		assertEquals(4,betManager.validate_bet(user, 1, 5));	
	}
	@Test
	public void test_validate_bet_premium() {
		
		Mockito.when(user.getType()).thenReturn(2);
		assertEquals(1,betManager.validate_bet(user, 2, 500));
	}
	@Test
	public void test_validate_bet_premium_5000() {
		Mockito.when(user.getType()).thenReturn(2);
		//Test condition if(b.getUsername().equals(username)) where names are not equal
		User test = Mockito.mock(User.class);
		Mockito.when(test.getUser()).thenReturn("Chris");
		Bet bet1 = new Bet("Chris",2,200);
		Mockito.when(user.getUser()).thenReturn("Jurgen");
		Mockito.when(bet.getUser()).thenReturn("Jurgen");
		Mockito.when(bet.getAmount()).thenReturn(4900);
		betManager.place_bet(bet);
		betManager.place_bet(bet1);
		assertEquals(0,betManager.validate_bet(user, 2, 500));
	}

}
