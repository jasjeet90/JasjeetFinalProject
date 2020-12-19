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
import pages.MyAddresses;
import pages.OrderConformatiom;
import pages.OrderHistory;
import pages.ShoppingCart;
import pages.SummerDresses;

public class AddBillingAddress extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	MyAccount myAccount;
	MyAddresses myAddresses;
	OrderHistory orderHistory;
	CommonPage commonPage;
	EveningDresses eveningDresses;
	ShoppingCart shoppingCart;
	OrderConformatiom orderConformation;
	SummerDresses summerDresses;

	@Test

	public void modificationInAddress() {

		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccount = new MyAccount(driver);
		commonPage = new CommonPage(driver);
		eveningDresses = new EveningDresses(driver);
		shoppingCart = new ShoppingCart(driver);
		orderConformation = new OrderConformatiom(driver);
		myAddresses= new MyAddresses(driver);
		orderHistory = new OrderHistory(driver);
		orderConformation = new OrderConformatiom(driver);
		commonPage = new CommonPage(driver);
		summerDresses = new SummerDresses(driver);
		SoftAssert asert = new SoftAssert();

		homePage.signin.click();
		test.log(LogStatus.INFO, "Signin");
		
		loginPage.loginWithUser("jasjeet@gmail.com", "jasjeet");
		test.log(LogStatus.INFO, "logged In");
		asert.assertEquals(driver.getTitle(), "My account - My Store");
		
		myAccount.myAddresses.click();
		test.log(LogStatus.INFO, "clickedOnMyAddresses");
		asert.assertEquals(driver.getTitle(), "Addresses - My Store");
		
		myAddresses.addNewAddress.click();
		test.log(LogStatus.INFO, "clicked On Add a New Address");
		
		String addrName = "BILLING ADDRESS";
		
		myAddresses.enterNewAddress(myAddresses.statte, "busyQA", "123RoberSpecs", "Brampton", "12345", "Alaska", "9915515025", "9316054780", addrName);
		test.log(LogStatus.INFO, "New Address Entered");
		myAddresses.submit.click();
		test.log(LogStatus.INFO, "New Address added");
		
		asert.assertEquals(myAddresses.addressTitle(driver, addrName).getText(), addrName);
		
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
		shoppingCart.unCheckSameAdd.click();
		test.log(LogStatus.INFO, "Un Check Same Address");
		shoppingCart.proceedToCheckOut2.click();
		test.log(LogStatus.INFO, "confirmAddressPage");
		shoppingCart.clickOnTermsAgrement.click();
		test.log(LogStatus.INFO, "checkTermAgreement");
		shoppingCart.finalCheckOut.click();
		test.log(LogStatus.INFO, "clickedOnFinalCheckOut");
		shoppingCart.payByCheck.click();
		test.log(LogStatus.INFO, "PayByCheck");
		shoppingCart.confirmOrder.click();
		asert.assertEquals(driver.getTitle(), "Order confirmation - My Store");
		test.log(LogStatus.INFO, "orderConfirm");
		
		commonPage = new CommonPage(driver);
		commonPage.goTOMyAccount.click();
		test.log(LogStatus.INFO, "backToMyAccount");
		myAccount.myAddresses.click();
		test.log(LogStatus.INFO, "clickedOnMyAddresses");
		asert.assertEquals(driver.getTitle(), "Addresses - My Store");
		myAddresses.deleteAddress.click();
		
		driver.switchTo().alert().accept();
		
		myAccount.signOut.click();
		test.log(LogStatus.INFO, "Clicked on SingnOut button");
		
		
		asert.assertAll();

	
		
		
		
		
		
		
		
		

	}

}
