package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class OrderHistory extends BaseDriver {

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/a[1]"))
	public WebElement reOrder;

	@FindBy(className = ("color-myaccount"))
	public WebElement recentOrder;

	public OrderHistory(WebDriver driver) {
		super(driver);
	}
}
