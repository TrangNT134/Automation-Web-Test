package com.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
	public void login(String email, String password) throws Exception {
    	Thread.sleep(2000);
    	WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
    	login.click();
		Thread.sleep(2000);
    	WebElement inputEmail = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
    	inputEmail.sendKeys(email);
		WebElement inputPassword = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
		inputPassword.sendKeys(password);
		WebElement signin = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
		signin.click();
		Thread.sleep(2000);
	}
	

}
