import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SampleTest {
WebDriver browser;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		browser = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		browser.quit();
	}
	@Test
	public void testregistration() {
		
		browser.get("http://localhost:8080/3222Assign/login.html");
		boolean inp;
		browser.findElement(By.cssSelector("a[href*='registration']")).click();
		List<WebElement> inputs = browser.findElements(By.className("form-group"));
		String [] ids = {"username_field","password_field","first_name","last_name","dob","type","credit_card_num","expiry_date","cvv"};
		for(int i = 0; i < inputs.size();i++)
		{
			
		}
		if(inputs.size() == 9)
			inp = true;
		else
			inp = false;

		assertTrue(inp);
		//assertTrue(features.getStories()>2);
	}
}
