package test.assign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Register {
	WebDriver browser;
	
	public Register(WebDriver browser)
	{
		this.browser = browser;
	}
	
	public void input_details(String arg1,String arg2,String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9)
	{
		List<WebElement> inputs = browser.findElements(By.className("form-group"));
		String [] ids = {"username_field","password_field","first_name","last_name","dob","type","credit_card_num","expiry_date","cvv"};
		System.out.println(inputs.size());
		for(int i = 0; i < inputs.size();i++)
		{
			WebElement field;
			try
			{
				 field = inputs.get(i).findElement(By.tagName("input"));
			}
			catch(NoSuchElementException e)
			{
				 field = inputs.get(i).findElement(By.tagName("select"));
			}
			System.out.println(field.getTagName());
			switch(field.getAttribute("id"))
			{
				case "username_field": field.click();field.sendKeys("Jurgen");
										break;
				case "password_field": field.sendKeys("12345678");
										break;
				case "first_name": field.sendKeys("Jurgen");
										break;
				case "last_name": field.sendKeys("Cassar");
										break;
				case "dob": field.sendKeys("25/04/1994");
										break;
				case "type": field.sendKeys("0");
										break;
				case "credit_card_num": field.sendKeys("371449635398431");
										break;
				case "expiry_date": field.sendKeys("05/2017");
										break;
				case "cvv": field.sendKeys("456");
										break;
			}
		}
		
	}
	public void submit_btn()
	{
		WebElement submitbtn = browser.findElement(By.id("submit"));
		submitbtn.click();
	}
	
	public String is_successful()
	{
		WebElement message = browser.findElement(By.id("message"));
		return message.getText();
	}
	public void edit_field(String field_name,String input)
	{
		System.out.println(field_name);
		WebElement field = browser.findElement(By.id(field_name));
		field.clear();
		field.sendKeys(input);
	}
	public String unsuccessful_message(String field)
	{
		WebElement message = browser.findElement(By.id("error_message"));
		return message.getText();
	}
	
	public void setUp()
	{
		WebElement before = browser.findElement(By.id("Beforetest"));
		before.click();
	}
	public void tearDown()
	{
		WebElement after = browser.findElement(By.id("Aftertest"));
		after.click();
	}
	
}
