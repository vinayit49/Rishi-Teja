package DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngProject {
	@Test(dataProvider="getdata",priority=0,groups= "login")
	public void AdminLogin(String user,String password)
	{
		System.out.println("The AdminLoginPage");
		System.out.println(user);
		System.out.println(password);
	}
	@Test
	public void AdminBrokenLinks()
	{
		System.out.println("The Admin broken link Page");
	}

	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="user1";
		data[0][1]="password1";
		data[1][0]="user2";
		data[1][1]="password2";
		data[2][0]="user3";
		data[2][1]="password3";
		
		return data;
				
	}
}
