package DataDriven;

import org.testng.annotations.Test;

public class TestngProject3 {
	@Test(groups= {"login"})
	public void facultylogin()
	{
		System.out.println("the faculty login page");
	}
	@Test
	public void facultybrokenlink()
	{
		System.out.println("the faculty broken link page");
	}

}
