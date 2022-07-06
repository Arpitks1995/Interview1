package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public static Logger log = Logger.getLogger(base.class.getName());
	public WebDriver intializeDriver() throws IOException {
		
	    prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Arpit\\eclipse-workspaceNew\\E2EProjects\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpit\\eclipse-workspaceNew\\E2EProjects\\driver\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arpit\\eclipse-workspaceNew\\E2EProjects\\driver\\geckodriver.exe");
			 driver=new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")) {
			System.setProperty(browserName, browserName);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);  
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}
	
	
	

}
