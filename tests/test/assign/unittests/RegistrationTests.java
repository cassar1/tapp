package test.assign.unittests;

import static org.junit.Assert.*;

import com.assign.services.UserManagement;
import com.assign.models.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class RegistrationTests {

	@Mock
	User user;
	User user2;
	UserManagement manager;
	@Before
	public void setUp() throws Exception 
	{
		user = new User();
		user2 = new User("better","12345678","John","Abela",
						"25/04/1992",0,"348334291014748","05/2017","123");
		//db = mock(Db_interaction.class);
		manager = new UserManagement();
	}

	@Test
	public void test_password() 
	{
		assertEquals(true, user.validate_password("12345678"));
	}
	@Test
	public void test_password_false() 
	{
		assertEquals(false, user.validate_password("1234567"));
	}
	@Test
	public void test_name() 
	{
		assertEquals(true, user.validate_name("John"));
	}
	@Test
	public void test_name2() 
	{
		assertEquals(true, user.validate_name("Jo hn"));
	}
	@Test
	public void test_name_false() 
	{
		assertEquals(false, user.validate_name(""));
	}
	@Test
	public void test_name_false2() 
	{
		assertEquals(false, user.validate_name("@34"));
	}
	@Test
	public void test_dob() 
	{
		assertEquals(true, user.validate_dob("25/04/1992"));
	}
	@Test
	public void test_dob_false() 
	{
		assertEquals(false, user.validate_dob("25/04/1998"));
	}
	@Test
	public void test_credit_num() 
	{
		assertEquals(true, user.validate_creditnum("348334291014748"));
	}
	@Test
	public void test_credit_num1() 
	{
		assertEquals(true, user.validate_creditnum("371449635398431"));
	}
	@Test
	public void test_credit_num2() 
	{
		assertEquals(true, user.validate_creditnum("5105105105105100"));
	}
	@Test
	public void test_credit_num3() 
	{
		assertEquals(true, user.validate_creditnum("5212345678901234"));
	}
	@Test
	public void test_credit_num4() 
	{
		assertEquals(true, user.validate_creditnum("5363836818572494"));
	}
	@Test
	public void test_credit_num5() 
	{
		assertEquals(true, user.validate_creditnum("5482520139786753"));
	}
	@Test
	public void test_credit_num6() 
	{
		assertEquals(true, user.validate_creditnum("5555555555554444"));
	}
	
	@Test
	public void test_credit_num7() 
	{
		assertEquals(true, user.validate_creditnum("4539778806615"));
	}
	@Test
	public void test_credit_num8() 
	{
		assertEquals(true, user.validate_creditnum("4024007143247244"));
	}
	@Test
	public void test_credit_false() 
	{
		assertEquals(false, user.validate_creditnum("212345678901234"));
	}
	@Test
	public void test_credit_false1() 
	{
		assertEquals(false, user.validate_creditnum("4"));
	}
	@Test
	public void test_credit_false2() 
	{
		assertEquals(false, user.validate_creditnum("abc"));
	}
	@Test
	public void test_expiry_false() 
	{
		assertEquals(false, user.validate_expiry("05/2005"));
	}
	@Test
	public void test_expiry() 
	{
		assertEquals(true, user.validate_expiry("05/2017"));
	}
	@Test
	public void test_cvv() 
	{
		assertEquals(true, user.validate_cvv("123"));
	}
	@Test
	public void test_cvv_false() 
	{
		assertEquals(false, user.validate_cvv("1234"));
	}
	@Test
	public void test_cvv_false2() 
	{
		assertEquals(false, user.validate_cvv("zcv"));
	}
	
	@Test
	public void test_add_user() 
	{
		User user = new User("better","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		assertTrue(manager.add_user(user));
	}
	@Test
	public void test_get_user() 
	{
		User user = new User("better","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		manager.add_user(user);
		assertEquals(user,manager.get_user("better"));
	}
	@Test
	public void test_get_user_null() 
	{
		User user = new User("better","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		manager.add_user(user);
		assertEquals(null,manager.get_user("abcdefgh"));
	}
	@Test
	public void test_duplicate_user() 
	{
		User duplicate_user = new User("better","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		manager.add_user(duplicate_user);
		assertTrue(manager.check_duplicate(duplicate_user.getUsername()));
	}
	@Test
	public void test_duplicate_use2() 
	{
		User user = new User("better","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		manager.add_user(user);
		assertFalse(manager.check_duplicate("paul"));
	}
	@Test
	public void test_login() 
	{
		User user = new User("better","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		System.out.println("size: " + manager.accounts.size());
		manager.add_user(user);
		assertEquals(user,manager.validate_login("better", "12345678"));
	}
	@Test
	public void test_login_false() 
	{
		User user = new User("better","12345678","John","Abela",
				"25/04/1992",0,"348334291014748","05/2017","123");
		System.out.println("size: " + manager.accounts.size());
		manager.add_user(user);
		assertEquals(null,manager.validate_login("better", "1234567"));
	}
	

}
