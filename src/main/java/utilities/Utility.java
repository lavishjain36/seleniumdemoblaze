package utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public static WebDriver driver;
	public Properties prop;
	
	//develop a functionality for browser launcher
	
	public WebDriver initializeDriver() throws IOException {
		//use the properties from data.properties
		prop=new Properties();
		//path to property
		String proppath=System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\data.properties";
		//create a fileinput stream object
		FileInputStream fis=new FileInputStream(proppath);
		prop.load(fis);//we can get the data from data.properties
		
		//develop a code for browser selection
		String choicebrowser="chrome";
//		String choicebrowser=prop.getProperty("browser", "chrome");
		if(choicebrowser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(choicebrowser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(choicebrowser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else {
			System.out.println("Invalid Browser Selection");
			System.exit(1);
		}
		//window maximazation
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//open google website					
		return driver;
	}
	
	
	//Add a functionality to capture screenshot
	public String takeScreenshot(String testname,WebDriver driver) throws IOException {
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//provide the path where we capture screenshot
		String screenshotfilepath=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
		//copy the file 
		FileUtils.copyFile(srcScreenshot, new File(screenshotfilepath));
		return screenshotfilepath;		
	}
	
	//Switching to window
	public static void SwitchWinodw() {
		String parentwindow=driver.getWindowHandle();
		Set<String> windowhandles=driver.getWindowHandles();
		windowhandles.size();
		
		//iterte through windows
		for(String childWindow:windowhandles) {
			if(!childWindow.contentEquals(parentwindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}
	
	//Function to wait for an element to be clickable
	public static WebElement waitforElementTobeClickable(By locator,int timeoutinseconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutinseconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	

}
