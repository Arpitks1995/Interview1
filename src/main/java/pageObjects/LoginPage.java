package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	By email=By.xpath("//input[@type=\"email\"]");
	By password=By.xpath("//input[@type=\"password\"]");
	By login=By.xpath("//input[@value=\"Log In\"]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
		
	}
	

	public WebElement getPassword() {
		return driver.findElement(password);
		
	}
	

	public WebElement getLogin() {
		return driver.findElement(login);
		
	}

}
