package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class MyAccount extends BaseDriver {

	@FindBy(className = ("account"))
	public WebElement accountName;

	@FindBy(className = ("logout"))
	public WebElement signOut;
	
	@FindBy(id = ("contact-link"))
	public WebElement contactUs;

	@FindBy(className = ("icon-list-ol"))
	public WebElement orderHistory;

	@FindBy(className = ("icon-building"))
	public WebElement myAddresses;

	public MyAccount(WebDriver driver) {
		super(driver);
	}
}
