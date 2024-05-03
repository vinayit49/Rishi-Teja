package RealSeleniumTestng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RealTimeInterview {
	
	WebDriver driver;
	@Test(priority=0)
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
	@Test(priority=1)
	public void verifyAlert()
	{
		WebElement ele=driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
		ele.click();
		System.out.println("The alert is clicble" +ele);
	}
	
	@Test(priority=2)
	public void verifyLinks()
	{
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("The links are:"+links.size());
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
		}
		
	}
	

}
