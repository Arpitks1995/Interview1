package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());

	
	
	@BeforeTest
	public void intialize() throws IOException {
		driver=intializeDriver();
		System.out.println("Postman1");
		System.out.println("Postman2");
		System.out.println("jira1");
	}
	
	
	
	
	@Test(dataProvider="getData")
	public void testBaseNavigation(String Username,String Password,String text) throws IOException {
		driver.get(prop.getProperty("url"));
	
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		
		lp.getLogin().click();
		
		
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[2][3];
		
		//0 Row
		data[0][0]="nonrestricteduser@gmail.com";
		data[0][1]="12345";
		data[0][2]="Non Restricted User";
		
		
		//1 Row
		data[1][0]="restricteduser@gmail.com";
		data[1][1]="12345";
		data[1][2]="Restricted User"; 
		 return data;
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
