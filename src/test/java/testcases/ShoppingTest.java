package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.CommonPage;
import pages.EveningDresses;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import pages.OrderConformatiom;
import pages.ShoppingCart;

public class ShoppingTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	CommonPage commonPage;
	MyAccount myAccount;
	EveningDresses eveningDresses;
	ShoppingCart shoppingCart;
	OrderConformatiom orderConformation;

	@Test
	public void shopping() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccount = new MyAccount(driver);
		commonPage = new CommonPage(driver);
		eveningDresses = new EveningDresses(driver);
		shoppingCart = new ShoppingCart(driver);
		orderConformation = new OrderConformatiom(driver);
		SoftAssert asert = new SoftAssert();

		logger.info("Login with user");
		homePage.signin.click();
		test.log(LogStatus.INFO, "Clicked on SingnIn button");
		loginPage.loginWithUser("jasjeet@gmail.com", "jasjeet");
		test.log(LogStatus.INFO, "Logged in");
		asert.assertEquals(driver.getTitle(), "My account - My Store");

		logger.info("Add dresses to cart");
		commonPage.hoverOnElement(driver, commonPage.women);
		commonPage.eveningDress.click();
		test.log(LogStatus.INFO, "Clicked on Evening dresses");
		asert.assertEquals(driver.getTitle(), "Evening Dresses - My Store");

		commonPage.hoverOnElement(driver, eveningDresses.printedDress);
		eveningDresses.addToCart.click();
		test.log(LogStatus.INFO, "Dress added to cart");

		eveningDresses.goToHome.click();
		test.log(LogStatus.INFO, "homeScreen");
		asert.assertEquals(driver.getTitle(), "My Store");

		homePage.scroll(driver);
		test.log(LogStatus.INFO, "scrollDown");
		commonPage.hoverOnElement(driver, homePage.blouse);
		test.log(LogStatus.INFO, "hoverOnBlouse");
		homePage.clickToCart.click();
		test.log(LogStatus.INFO, "clickOnAddCart");

		logger.info("Proceed to checkout");
		homePage.proceedToCheckOut.click();
		asert.assertEquals(driver.getTitle(), "Order - My Store");

		test.log(LogStatus.INFO, "clickedOnCheckOut");
		homePage.scroll(driver);
		shoppingCart.proceedToCheckOut.click();
		test.log(LogStatus.INFO, "clickedOnCheckOutOnOrderPage");
		shoppingCart.proceedToCheckOut2.click();
		test.log(LogStatus.INFO, "confirmAddressPage");
		shoppingCart.clickOnTermsAgrement.click();
		test.log(LogStatus.INFO, "checkTermAgreement");
		shoppingCart.finalCheckOut.click();
		test.log(LogStatus.INFO, "clickedOnFinalCheckOut");
		shoppingCart.payByBank.click();
		test.log(LogStatus.INFO, "PayByBankWire");
		shoppingCart.confirmOrder.click();
		asert.assertEquals(driver.getTitle(), "Order confirmation - My Store");
		test.log(LogStatus.INFO, "orderConfirm");
		myAccount.signOut.click();
		test.log(LogStatus.INFO, "Clicked on SingnOut button");
		
		asert.assertAll();

	}
}