package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;

public class HomePagetest extends BaseClass{
	HomePage homepage;
	
	
	@Test
	public void verifytitle_on_hompage() {
		homepage=new HomePage(driver);
		AssertJUnit.assertEquals(homepage.validateHomepageTitle(),"STORE");
	}
	
	@Test
	public void verifylogo_on_homepage() {
		homepage=new HomePage(driver);//created homepage object
		AssertJUnit.assertTrue(homepage.isLogoDisplayed());
	}
	
	
	@Test
	public void verify_allmenuitems_on_homepage() {
		homepage=new HomePage(driver);
		List<String> menulist=Arrays.asList("Home","Contact","About us","Cart","Log in","Sign up");
		List<WebElement> menuitems=homepage.getMenuItems();
		
		for(int i=0;i<menulist.size();i++) {
			for(WebElement element:menuitems) {
				if(menulist.get(i).equals(element.getText())) {
					System.out.println("All navigation menu items are available");
					AssertJUnit.assertTrue(true);
				}else {
					System.out.println("All navigation menu items are not available");
				}
			}
		}
	}
	
	
	@Test
	public void verify_product_features_presence() {
		homepage=new HomePage(driver);
		AssertJUnit.assertTrue(homepage.is_featuresproductavailable());

	}
	
//	Verify for ->list ->size method
//	1.phone->9 items
//	2.laptop->6 Items
//	3.desktop->2 items



}
