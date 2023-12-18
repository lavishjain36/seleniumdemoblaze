package base;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Utility;

//inheritance->the functionality of browser launching
public class BaseClass extends Utility {
	
	//write code for starting and closing of the browser
	@BeforeMethod
	public void startup() throws IOException {
		driver=initializeDriver();
		//send the website url
		driver.get(prop.getProperty("url"));//it will set the url ->
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
