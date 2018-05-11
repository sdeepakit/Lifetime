package org.demoqa.Lifetime;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LifeTime {
	WebDriver driver_chrome, driver_firefox;
	@Given("^the user selects Browser and user in Lifetime website$")
	public void the_user_selects_Browser_and_user_in_Lifetime_website() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "I:\\Users\\Deepak\\workspace\\Lifetime\\Driver\\chromedriver.exe");
	   driver_chrome = new ChromeDriver();
	   driver_chrome.get("https://www.lifetime.life");
	   
	   System.setProperty("webdriver.gecko.driver", "I:\\Users\\Deepak\\workspace\\Lifetime\\Driver\\geckodriver.exe");
	   driver_firefox = new FirefoxDriver();
	   driver_firefox.get("https://www.lifetime.life");
	   
	   
	}

	@When("^the user select Sports menu and clicking the Basketball option$")
	public void the_user_select_Sports_menu_and_clicking_the_Basketball_option() throws Throwable {
		driver_chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver_chrome.findElement(By.xpath("//*[contains(text(),'×')]")).click();
		driver_chrome.findElement(By.linkText("Sports")).click();
		driver_chrome.findElement(By.linkText("Basketball")).click();	
		
		driver_firefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver_firefox.findElement(By.xpath("//*[contains(text(),'×')]")).click();
		driver_firefox.findElement(By.linkText("Sports")).click();
		driver_firefox.findElement(By.linkText("Basketball")).click();	
		
		
	}

	@Then("^the user verifing message 'Premier Basketball Courts' is available or not$")
	public void the_user_verifing_message_Premier_Basketball_Courts_is_available_or_not() throws Throwable {
		driver_chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String verify = driver_chrome.findElement(By.xpath("//div[10]/div/div/div/h4")).getText();
		System.out.println(verify);  
		Assert.assertEquals("Premier Basketball Courts",verify);
		
		driver_firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String verify1 = driver_firefox.findElement(By.xpath("//div[10]/div/div/div/h4")).getText();
		System.out.println(verify1);  
		Assert.assertEquals("Premier Basketball Courts",verify1);
	}


}
