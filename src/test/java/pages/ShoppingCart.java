package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class ShoppingCart extends BaseDriver {

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]"))
	public WebElement proceedToCheckOut;

	@FindBy(css = ("button[name='processAddress']"))
	public WebElement proceedToCheckOut2;

	@FindBy(xpath = ("//input[@id='cgv']"))
	public WebElement clickOnTermsAgrement;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]"))
	public WebElement finalCheckOut;

	@FindBy(className = ("bankwire"))
	public WebElement payByBank;

	@FindBy(id = ("addressesAreEquals"))
	public WebElement unCheckSameAdd;

	@FindBy(xpath = ("//label[contains(text(),'Choose a billing address:')]"))
	public WebElement billingAddress;

	@FindBy(className = ("cheque"))
	public WebElement payByCheck;

	@FindBy(xpath=("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]"))
	 public WebElement confirmOrder;
	
	@FindBy(xpath = ("//a[@id='cart_quantity_up_2_7_0_407318']"))
	public WebElement addBlouse;

	@FindBy(xpath = ("//a[@id='4_16_0_407318']"))
	public WebElement deletePrintDress;
	
	public ShoppingCart(WebDriver driver) {
		super(driver);
	}
}
