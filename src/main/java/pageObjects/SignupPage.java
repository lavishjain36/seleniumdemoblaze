package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	//create WebDriver variable
	public WebDriver driver;
	
	//Initialize pageFactory class init method in constructor
	public SignupPage(WebDriver driver) {
		//intialize page factory init and driver 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locate an element available on Signup page
	
	//signup dashboard link
	@FindBy(id="signin2")
	WebElement signupclicklink;
	
	//username
	@FindBy(id="sign-username")
	WebElement usernamefield;
	
	//password
	@FindBy(id="sign-password")
	WebElement userpassword;
	
	//submit btn
	@FindBy(xpath="//button[.='Sign up']")
	WebElement usersignuploginbtn;
	
	@FindBy(xpath="(//button[.='Close'])[2]")
	WebElement usersignupclosebtn;
	
	
	//create method
	public void signuplinkclick() {
		signupclicklink.click();
	}
	
	
	public void getusername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void getuserpassword(String password) {
		userpassword.sendKeys(password);
	}
	
	
	public void click_submit_signup() {
		usersignuploginbtn.click();
	}
	

}
