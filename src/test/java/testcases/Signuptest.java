package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.SignupPage;

public class Signuptest extends BaseClass  {

	
	@Test
	public void signup() throws InterruptedException {
		//create an object of SignupPage class
		SignupPage signup=new SignupPage(driver);
		signup.signuplinkclick();
		signup.getusername(prop.getProperty("username"));
		Thread.sleep(1000);
		signup.getuserpassword(prop.getProperty("userpassword"));
		Thread.sleep(1000);
		signup.click_submit_signup();//calling this method
	}
}
