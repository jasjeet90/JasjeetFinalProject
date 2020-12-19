package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseDriver{
	public BaseDriver(WebDriver driver) {
    PageFactory.initElements(driver, this);
}
}
