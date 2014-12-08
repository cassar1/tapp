package test.assign.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BettingPo {
WebDriver browser;
	
	public BettingPo(WebDriver browser)
	{
		this.browser = browser;
	}
	
	public void placeBet(String risk, String amt)
	{
		WebElement place_bet_btn = browser.findElement(By.id("place_bet"));
		place_bet_btn.click();
		browser.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement risk_field = browser.findElement(By.tagName("select"));
		risk_field.sendKeys(risk);
		WebElement bet_field = browser.findElement(By.id("betting_amount"));
		bet_field.sendKeys(amt);
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement modal = browser.findElement(By.className("modal-footer"));
		WebElement place_btn = modal.findElement(By.id("place_bet"));
		place_btn.click();
	}
	
	public String check_success()
	{
		WebElement msg = browser.findElement(By.id("message"));
		String message = msg.getText();
		return message;
	}
}
