package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BaseDriver;

public class CustomerService extends BaseDriver {

	public CustomerService(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = ("//select[@id='id_contact']"))
	public WebElement heading;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[2]/div[1]/select[1]"))
	public WebElement orderReference;
	
	@FindBy(id =("message"))
	public WebElement message;
	
	@FindBy(id =("submitMessage"))
	public WebElement sendMessage;
	
	@FindBy(xpath = ("//p[contains(text(),'Your message has been successfully sent to our tea')]"))
	public WebElement messageSent;
	


	public void headingDropDown(String value) {
		Select findSelect4 = new Select(heading);
		findSelect4.selectByVisibleText(value);
	}

	public void orderRefDropDown(String value) {
		Select findSelect4 = new Select(orderReference);
		findSelect4.selectByVisibleText(value);
	}
	
	

}
