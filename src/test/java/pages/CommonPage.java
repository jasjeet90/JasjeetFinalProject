package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class CommonPage extends BaseDriver {

	@FindBy(css = ("a[title='Women']"))
	public WebElement women;

	@FindBy(css = ("a[title='Evening Dresses']"))
	public WebElement eveningDress;

	@FindBy(xpath = ("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"))
	public WebElement dresses;

	@FindBy(xpath = ("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]"))
	public WebElement summerDress;
	
	@FindBy(xpath=("//header/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]"))
	 public WebElement goTOMyAccount;

	public CommonPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * This method hovers on given webElement
	 * @param driver - Webdriver
	 * @param webElement - WebElement
	 */
	public void hoverOnElement(WebDriver driver, WebElement webElement) {
		Actions action = new Actions(driver);
		action.moveToElement(webElement).perform();
	}
}
