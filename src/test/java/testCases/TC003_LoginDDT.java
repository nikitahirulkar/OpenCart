package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class,groups="Datadriven") //getting data provider from different class  
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("************ Starting TC003_LoginDDT *****************");
		try
		{
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
				
		//Login
		AccountLoginPage lp=new AccountLoginPage(driver);
				
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.btnLogin();
				
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountExist();
		
		/*Data is  valid - login success - test pass - logout
		  				   login fail -test fail
		  
		  Data is  invalid - login success - test fail - logout
		                     login fail -test pass
		 */
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true );
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("************Finished TC003_LoginDDT *****************");

	}

}
