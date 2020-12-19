package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseDriver;

public class SummerDresses extends BaseDriver {

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]"))
	public WebElement printedSummerDress;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[2]/div[2]/a[1]"))
	public WebElement addSummerDress;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]"))
	public WebElement printedChiffonDress;

	@FindBy(xpath = ("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/div[2]/a[1]"))
	public WebElement addChiffonDress;

	@FindBy(xpath = ("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/span[1]"))
	public WebElement continueShopping;

	public SummerDresses(WebDriver driver) {
		super(driver);

	}

}
