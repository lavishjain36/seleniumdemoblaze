package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//create WebDriver variable
	public WebDriver driver;
		public HomePage(WebDriver driver) {
			//intialize page factory init and driver 
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
	//Locate an element on the page 
		
	@FindBy(xpath="(//img[@src='bm.png'])[1]")
	WebElement logo;
	
	
	@FindBy(xpath="//div[@id='navbarExample']/ul/li[1]/a")
	WebElement hometext;
	
	@FindBy(xpath="//div[@id='navbarExample']/ul/li")
	List<WebElement> allmenuitems;
	
	@FindBy(xpath=" //div[@id='tbodyid']/div[1]/div/div/h4/a")
	WebElement Samsunggalaxys6;
	
	
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	//create method to verify title of the page
	public String validateHomepageTitle() {
		return driver.getTitle();
	}
	
	//return collection of item
	public List<WebElement> getMenuItems(){
		return allmenuitems;
	}
	
	public boolean is_featuresproductavailable() {
		return Samsunggalaxys6.isDisplayed();
	}
}
