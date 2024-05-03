package RealSeleniumTestng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sampletestngproject {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver,chrome.driver","C:\\Users\\New\\eclipse-workspace\\Vinay\\SampleSelenium\\driver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://www.amazon.in");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Parameters({"url","key"})
	@Test(priority=2,groups={"Verify"})
	public void verifyTitle(String myurl ,Integer key)
	{
		String actialTitle=driver.getTitle();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actialTitle, expectedTitle);
		System.out.println(myurl);
		System.out.println(key);
	}
	@Test(invocationCount=2,priority=1,groups={"Verify"})
	public void VerifyLogo()
	{
	WebElement logo=driver.findElement(By.xpath("//span[@id='logo-ext']"));
	           logo.isDisplayed();
	           logo.getText();
	}
	@Test(priority=0,groups={"SmokeTest"})
	public void verifyNumberofLinks()
	{
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("The links are:"+links.size());
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
		}
	}
	@Test(dataProvider="getdata",priority=3)
	public void VerifyLogin(String user,String password) throws InterruptedException
	{
		//driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
		driver.findElement(By.xpath("(//span[@class='nav-line-2'])[2]")).click();
		System.out.println(user);
		System.out.println(password);
		driver.findElement(By.xpath("//input[@name='email']"));
		driver.findElement(By.xpath("//input[@name='password']"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(3000);
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="vinayit49@gmail.com";
		data[0][1]="Bhanuteja@71625";
		data[1][0]="user2";
		data[1][1]="password2";
		data[2][0]="user3";
		data[2][1]="password3";
		return data;
				
	}
  @AfterMethod
public void teardown()
	{
		driver.quit();
	}
}
