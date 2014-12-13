package test.assign.pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPo {

	public WebDriver browser;
	
	public LoginPo(WebDriver browser)
	{
		this.browser = browser;
	}
	public boolean login(String username,String pass)
	{
		WebElement user_field = browser.findElement(By.id("username_field"));
		WebElement pass_field = browser.findElement(By.id("password_field"));
		user_field.sendKeys(username);
		pass_field.sendKeys(pass);
		WebElement submitbtn = browser.findElement(By.id("submitbtn"));
		submitbtn.click();
		try
		{
			WebElement table = browser.findElement(By.id("bets_table"));
			if(table != null)
				return true;
			else
				return false;
		}catch(NoSuchElementException e)
		{
			return false;
		}
	}
	public String getMessage()
	{
		WebElement msg = browser.findElement(By.id("message"));
		String message = msg.getText();
		return message;
	}
}
