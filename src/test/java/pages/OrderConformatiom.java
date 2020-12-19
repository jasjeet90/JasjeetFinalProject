package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class OrderConformatiom extends BaseDriver {

	@FindBy(xpath=("//p[contains(text(),'Your order on My Store is complete.')]"))
	 public WebElement conformation;

	public OrderConformatiom(WebDriver driver) {
		super(driver);
	}
}
