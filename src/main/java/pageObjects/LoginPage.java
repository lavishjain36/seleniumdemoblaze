package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//create WebDriver variable
	public WebDriver driver;

	//intialize pageFactory and driver
	//Initialize pageFactory class init method in constructor
		public LoginPage(WebDriver driver) {
			//intialize page factory init and driver 
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
//	link click
	@FindBy(id="login2")
	WebElement loginlinkfield;
	
	//Locate the element on tha page
	@FindBy(id="loginusername")	
	WebElement usernameloginfield;
	
	@FindBy(id="loginpassword")
	WebElement userpasswordloginfield;
	
	@FindBy(xpath="//button[.='Log in']")
	WebElement userloginbtn;
	
	//create 4 methods 
	
	  //create method
		public void loginlinkclick() {
			loginlinkfield.click();
		}
		
		public void getusername(String username) {
			usernameloginfield.sendKeys(username);
		}
		
		public void getuserpassword(String password) {
			userpasswordloginfield.sendKeys(password);
		}
		
		public void click_submit_login() {
			userloginbtn.click();
		}
	
}
