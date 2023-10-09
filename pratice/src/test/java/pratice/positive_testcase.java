package pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class positive_testcase 
{
	static WebDriver drv;

	
	@Parameters("url")
	@BeforeTest
	public static void lunch(String url) throws InterruptedException 
	{
		drv=new ChromeDriver();
		drv.get(url);
		drv.manage().window().maximize();
		Thread.sleep(3000);
		drv.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

	}
	@Parameters({"nm","pwd1"})
	@Test
	public static void valid_credential(String nm,String pwd1) 
	{
		By uname=By.name("username");
		WebElement name=drv.findElement(uname);
		name.sendKeys(nm);
		By pwd=By.name("password");
		WebElement password=drv.findElement(pwd);
		password.sendKeys(pwd1);
		drv.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();

	}

	@AfterTest
	public static void close() 
	{
		drv.quit();
	}
}
