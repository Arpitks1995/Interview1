package Academy;

import java.io.IOException;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base {

	public WebDriver driver;
	Logger log=Logger.getLogger(ValidateTitle.class);
	
	@BeforeTest
	public void intialize() throws IOException {
		
		driver=intializeDriver();
		Testing.xyz();
		driver.get(prop.getProperty("url"));
	
	}

	@Test
	public void basePageNavigation() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("url is opened");
		LandingPage lp=new LandingPage(driver);
		
		//Assert.assertEquals(lp.getTitle().getText(), "FEATUREDCOURSES");
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.debug("I am doing debuging");
		log.error("Error is here");
		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
