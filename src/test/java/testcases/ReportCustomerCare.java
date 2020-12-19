package testcases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.CommonPage;
import pages.CustomerService;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import pages.OrderConformatiom;
import pages.OrderHistory;
import pages.ShoppingCart;
import pages.SummerDresses;

public class ReportCustomerCare extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	CommonPage commonPage;
	MyAccount myAccount;
	SummerDresses summerDresses;
	OrderConformatiom orderconformation;
	OrderHistory orderHistory;
	CustomerService customerService;
	ShoppingCart shoppingCart;

	@Test
	public void reportCustomerCare() {

		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccount = new MyAccount(driver);
		commonPage = new CommonPage(driver);
		summerDresses = new SummerDresses(driver);
		shoppingCart = new ShoppingCart(driver);
		orderconformation = new OrderConformatiom(driver);
		orderHistory = new OrderHistory(driver);
		customerService = new CustomerService(driver);
		SoftAssert asert = new SoftAssert();

		homePage.signin.click();
		test.log(LogStatus.INFO, "Clicked On SignIn Button");

		loginPage.loginWithUser("jasjeet@gmail.com", "jasjeet");

		asert.assertEquals(driver.getTitle(), "My account - My Store");

		commonPage.hoverOnElement(driver, commonPage.dresses);
		test.log(LogStatus.INFO, "Mouse Hover On Dresses");

		commonPage.summerDress.click();
		test.log(LogStatus.INFO, "Clicked On SummerDresses");
		asert.assertEquals(driver.getTitle(), "Summer Dresses - My Store");

		commonPage.hoverOnElement(driver, summerDresses.printedSummerDress);
		test.log(LogStatus.INFO, "Mouse Hover On Summer Dress");
		summerDresses.addSummerDress.click();
		test.log(LogStatus.INFO, "clicked On Summer Dress");
		summerDresses.continueShopping.click();

		commonPage.hoverOnElement(driver, summerDresses.printedChiffonDress);
		test.log(LogStatus.INFO, "Mouse Hover On Chiffon Dress");
		summerDresses.addChiffonDress.click();

		test.log(LogStatus.INFO, "clicked On chiffon Dress");

		homePage.proceedToCheckOut.click();
		test.log(LogStatus.INFO, "clickedOnCheckOut");
		shoppingCart.proceedToCheckOut.click();
		test.log(LogStatus.INFO, "clickedOnCheckOutOnOrderPage");

		shoppingCart.proceedToCheckOut2.click();
		test.log(LogStatus.INFO, "confirmAddressPage");
		shoppingCart.clickOnTermsAgrement.click();
		test.log(LogStatus.INFO, "checkTermAgreement");
		shoppingCart.finalCheckOut.click();
		test.log(LogStatus.INFO, "clickedOnFinalCheckOut");
		shoppingCart.payByCheck.click();
		test.log(LogStatus.INFO, "PayBycheck");
		shoppingCart.confirmOrder.click();
		test.log(LogStatus.INFO, "OrderConfirmed");

		commonPage.goTOMyAccount.click();
		test.log(LogStatus.INFO, "Go to My Account Page");

		myAccount.orderHistory.click();
		test.log(LogStatus.INFO, "clickedOnOderHistory");
		asert.assertEquals(driver.getTitle(), "Order history - My Store");

		String orderNumber = orderHistory.recentOrder.getText();
		test.log(LogStatus.INFO, "getReferenceCode");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = (dtf.format(now));
		String referenceCode = orderNumber + " - " + date;

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1400);");
		test.log(LogStatus.INFO, "Scroll to Page bottom");

		myAccount.contactUs.click();
		test.log(LogStatus.INFO, "Clicked on ContactUs");

		customerService.headingDropDown("Customer service");
		test.log(LogStatus.INFO, "select customer Service");
		customerService.orderRefDropDown(referenceCode);
		test.log(LogStatus.INFO, "your order Selected");

		customerService.message.sendKeys("I Want To Cancel My Order");
		test.log(LogStatus.INFO, "Message written to Customer service");
		customerService.sendMessage.click();
		test.log(LogStatus.INFO, "Clicked on Send Message");
		asert.assertEquals(customerService.messageSent.getText(),
				"Your message has been successfully sent to our team.");
		test.log(LogStatus.INFO, "Message Sucessfully Sent");
		
		myAccount.signOut.click();
		test.log(LogStatus.INFO, "Clicked on SingnOut button");
		
		asert.assertAll();

	}

}
