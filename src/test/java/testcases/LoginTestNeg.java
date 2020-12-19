package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import utilites.ReadExcelData;

public class LoginTestNeg extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	MyAccount myAccount;

	@Test(dataProvider = "LoginCheck")
	public void verifyLogin(String uid, String paswd, String name) {
		SoftAssert asert = new SoftAssert();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccount = new MyAccount(driver);

		logger.info("Login with user by getting data from excel sheet");
		homePage.signin.click();
		test.log(LogStatus.INFO, "Clicked on SingnIn button");
		test.log(LogStatus.INFO, "Trying to login with invalid password");
		loginPage.loginWithUser(uid, paswd);
		asert.assertEquals(loginPage.message.getText(), "Authentication failed.");
	}

	@DataProvider(name = "LoginCheck")
	public Object[][] passdata() throws IOException {
		ReadExcelData readExcelData = new ReadExcelData();
		return readExcelData.passdata(System.getProperty("user.dir") + "//src//ExcelData//loginlistNeg.xlsx", 0);
	}
}
