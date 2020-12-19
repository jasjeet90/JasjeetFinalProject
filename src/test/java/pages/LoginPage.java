package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class LoginPage extends BaseDriver {

	@FindBy(id = ("email"))
	public WebElement ulogin;

	@FindBy(id = ("passwd"))
	public WebElement password;

	@FindBy(id = ("SubmitLogin"))
	public WebElement loginbtn;
	
	@FindBy(className = ("alert"))
	public WebElement message;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * This method is used to login
	 * 
	 * @param uid - username
	 * 
	 * @param pwd - password
	 */
	public void loginWithUser(String uid, String pwd) {
		ulogin.sendKeys(uid);
		password.sendKeys(pwd);
		loginbtn.click();

	}
}
