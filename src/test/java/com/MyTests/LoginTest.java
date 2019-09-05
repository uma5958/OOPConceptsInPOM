package com.MyTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(priority=1, enabled=true)
	public void verify_loginPage_title_Test() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		Reporter.log("LoginPage title is: "+title, true);
		Assert.assertEquals(title, "HubSpot Login");
		Reporter.log("Login Page title verified", true);
	}
	
	@Test(priority=2, enabled=true)
	public void verify_LoginPage_header_Test() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		Reporter.log("LoginPage header is: "+header, true);
		Assert.assertEquals(header, "Don't have an account?");
	}
	
	@Test(priority=3, enabled=true)
	public void doLogin_Test() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("naveenanimation20@gmail.com", "Test@12345");
		String headerHome = homePage.getHomePageHeader();
		Reporter.log("HomePage header: "+headerHome, true);
		Assert.assertEquals(headerHome, "Getting started with Hub Spot");
	}
	
	
}
