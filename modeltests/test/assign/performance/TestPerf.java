package test.assign.performance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import net.sourceforge.czt.modeljunit.GreedyTester;
import net.sourceforge.czt.modeljunit.VerboseListener;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import test.assign.models.BettingSite;
import test.assign.models.TestVM;

import com.assign.models.User;

import junit.framework.TestCase;

public class TestPerf extends TestCase {

	Connection con;
	Connection.Response resp;
	Document doc;
	String sessionId;
	User u;
	BettingSite site;
	ArrayList<String> time;
	
	/*HashMap<String,ArrayList<String>> timer;
	ArrayList<String> Login;
	ArrayList<String> Register;
	ArrayList<String> Bet;*/
	
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
	public TestPerf(String name) {
        super(name);

    }
	
	protected void setUp() {

	}

	protected void tearDown() {
	}
	
	/*public void correctRegistrationTest() throws Exception {
		u = new User(generateRandomString(), "testpass", "Joe", "Borg", "11/08/1990", 1, "378282246310005", "05/2017", "123");
		site.inputRegistrationDetails(u);
		site.inputLoginDetails(u.getUsername(), u.getPassword());
		site.inputBetDetails(1, "5");
	}*/
	
	public void testFsm()throws Exception
	{
		GreedyTester t = new GreedyTester(new TestVM());
		t.addListener(new VerboseListener());
		t.generate(1);
		t.buildGraph();
		time = TestVM.timer;
		BufferedWriter writer1 = new BufferedWriter( new FileWriter( "login.csv"));
		BufferedWriter writer2 = new BufferedWriter( new FileWriter( "register.csv"));
		BufferedWriter writer3 = new BufferedWriter( new FileWriter( "bet.csv"));
		String sec;
		for(int i = 0; i < time.size();i++)
		{
			sec = time.get(i);
			if(sec.contains("Login"))
			{
				writer1.write(sec);
				writer1.newLine();
			}
			else if(sec.contains("Register"))
			{
				writer2.write(sec);
				writer2.newLine();
			}
			else if(sec.contains("Bet"))
			{
				writer3.write(sec);
				writer3.newLine();
			}
		}
		writer1.close();
		writer2.close();
		writer3.close();
		/*System.out.println("\nRegister");
		for(int i = 0; i < time.size();i++)
		{
			sec = time.get(i);
			if(sec.contains("Register"))
				System.out.println(sec);
		}
		System.out.println("\nBet");
		//time = timer.get("Bet");
		for(int i = 0; i < time.size();i++)
		{
			sec = time.get(i);
			if(sec.contains("Bet"))
				System.out.println(sec);
		}*/
	}
	
	public String generateRandomString(){
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
