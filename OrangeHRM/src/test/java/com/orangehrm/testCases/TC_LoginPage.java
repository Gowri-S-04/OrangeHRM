package com.orangehrm.testCases;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangehrm.pageObjects.LoginPage;
import com.orangehrm.utilities.XLUtils;

public class TC_LoginPage extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginPage(String uname, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(d);
		lp.userName(uname);
		log.info("Username Entered");
		Thread.sleep(2000);
		lp.passWord(pwd);
		log.info("Password Entered");
		Thread.sleep(2000);
		lp.login();
		log.info("Logined to Application");
		Thread.sleep(2000);
		//captureScreenshot("LoginPage");
		lp.welcome();
		log.info("Welcome is Clicked");
		Thread.sleep(2000);
		lp.logout();
		log.info("LoggedOut of Application");
		Thread.sleep(2000);
	}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="./src\\test\\java\\com\\orangehrm\\testData\\LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}	
		}
	return logindata;
	}
}