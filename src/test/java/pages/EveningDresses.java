package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class EveningDresses extends BaseDriver {

	 @FindBy(xpath=("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]"))
	    public WebElement printedDress;
	 
	 @FindBy(xpath=("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]"))
	    public WebElement addToCart;

	 @FindBy(xpath=("//body/div[@id='page']/div[2]/div[1]/div[1]/a[1]/i[1]"))
	    public WebElement goToHome;

		public EveningDresses(WebDriver driver) {
			super(driver);
		}
}
