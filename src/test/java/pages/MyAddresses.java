package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BaseDriver;

public class MyAddresses extends BaseDriver {

	@FindBy(css = ("a[title='Add an address']"))
	public WebElement addNewAddress;

	@FindBy(id = ("company"))
	public WebElement company;

	@FindBy(id = ("address1"))
	public WebElement addres;

	@FindBy(id = ("city"))
	public WebElement ciity;

	@FindBy(id = ("id_state"))
	public WebElement statte;

	@FindBy(id = ("postcode"))
	public WebElement postcode;

	@FindBy(id = ("phone"))
	public WebElement homePhone;

	@FindBy(id = ("phone_mobile"))
	public WebElement mobilePhone;

	@FindBy(id = ("alias"))
	public WebElement addressTittle;

	@FindBy(id = ("submitAddress"))
	public WebElement submit;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[9]/a[2]/span[1]"))
	public WebElement deleteAddress;

	public MyAddresses(WebDriver driver) {
		super(driver);
	}

	/*
	 * This method Adds New Address
	 */
	public void enterNewAddress(WebElement webElement, String companyName, String address, String city,
			String postalCode, String state, String homephone, String mobilenumber, String addresstitle) {
		company.sendKeys(companyName);
		addres.sendKeys(address);
		ciity.sendKeys(city);
		Select findSelect4 = new Select(webElement);
		findSelect4.selectByVisibleText(state);
		postcode.sendKeys(postalCode);
		homePhone.sendKeys(homephone);
		mobilePhone.sendKeys(mobilenumber);
		addressTittle.clear();
		addressTittle.sendKeys(addresstitle);

	}

	public WebElement addressTitle(WebDriver driver, String address) {
		return driver.findElement(By.xpath("//h3[contains(text(),'" + address + "')]"));
	}
}
