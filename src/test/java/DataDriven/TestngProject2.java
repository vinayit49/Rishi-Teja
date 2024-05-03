package DataDriven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngProject2 {
@BeforeMethod
public void beforemethod()
{
	System.out.println("before method...");
}
@AfterMethod
public void Aftermethod()
{
	System.out.println("after method...");
}	
@Test(groups= {"login"})
public void placementlogin()
{
	System.out.println("The placement login page");
}

public void placementbrokenlink()
{
	System.out.println("The placement brokenlink page");
}
}
