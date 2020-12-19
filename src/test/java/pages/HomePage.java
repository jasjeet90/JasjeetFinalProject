package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class HomePage extends BaseDriver {

	@FindBy(linkText = ("Sign in"))
	public WebElement signin;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]"))
	public WebElement blouse;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/div[2]/a[1]"))
	public WebElement clickToCart;

	@FindBy(css = ("a[title='Proceed to checkout']"))
	public WebElement proceedToCheckOut;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void scroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600);");
	}
}
