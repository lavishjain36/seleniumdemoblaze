package testcases;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class Logintest extends BaseClass {
	
	
	
	//define a method   that should drive data frome excel file to test case login
	@DataProvider(name="loginData")
	public Object[][] getLoginData() throws EncryptedDocumentException, IOException, InterruptedException{
		//create a file object from where i want to pull the data
		FileInputStream file=new FileInputStream("D:\\JavaConcept\\pomdevelopment\\src\\test\\java\\testdata\\LoginData.xlsx");	
		//create a workbook object to handle excel data
		Workbook workbook=WorkbookFactory.create(file);
		//Access the sheet with Sheet1
		Sheet sheet=workbook.getSheet("Sheet1");	
		//get the total number of rows in sheet
		int rowcount=sheet.getLastRowNum();
		//get column
		int columnCount=sheet.getRow(0).getLastCellNum();//columns no.	
		//create 2d array to store the data from excel sheet
		Object[][] data=new Object[rowcount][columnCount];
		//keep thread
		Thread.sleep(2000);
		//iterate through each column in the row to read the data
		for(int i=0;i<rowcount;i++) {
			//get the current row
			Row row=sheet.getRow(i+1);
			
			//iterate through column 
			for(int j=0;j<columnCount;j++) {
				Cell cell=row.getCell(j);
				
				//store the cell value ->check if cell is null or not
				data[i][j]=(cell!=null)?cell.toString():null;
			}
		}
		return data;
	}
     
	@Test(dataProvider ="loginData")
	public void LoginWith_Valid_Credentials(String username,String password) throws InterruptedException {
	    Reporter.log("Welcome to login page",true);
		//create an object LoginPage
		LoginPage loginobj=new LoginPage(driver);
		loginobj.loginlinkclick();
		Thread.sleep(3000);
//		loginobj.getusername(prop.getProperty("username"));
		loginobj.getusername(username);
		loginobj.getuserpassword(password);
//		loginobj.getuserpassword(prop.getProperty("userpassword"));
		Thread.sleep(1000);
		loginobj.click_submit_login();//click that button
	}
	
	
	
	

	
}
