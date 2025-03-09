package com.tests;


import POM.PasswordPage;
import POM.UsernamePage;
import POM.WelcomePage;
import TestUtils.WaitUtils;
import TestUtils.WindowHandleUtility;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestClass extends BaseTest {
    private static WelcomePage welcomePage;
    private static UsernamePage usernamePage;
    private static PasswordPage passwordPage;
    private static WindowHandleUtility windowHandleUtility;

    @BeforeSuite
    public void setUpMethod() {
        welcomePage = WelcomePage.getInstance();
        usernamePage = UsernamePage.getInstance();
        passwordPage = PasswordPage.getInstance();
        windowHandleUtility = WindowHandleUtility.getInstance();
    }

    @AfterSuite
    public void tearDown() {
//        staticWait(5000);
//        getDriver().quit();
    }


    @Test(priority = 0, description = "Logging in to outlook by clicking sign-in button")
    public static void firstTest() {
        welcomePage.clickSignInButton();
    }

    @Test(priority = 1, description = "Entering Username into username textbox", dependsOnMethods = "firstTest")
    public static void secondTest() {
       String pageTitle = windowHandleUtility.returnPageTitle();

        if(pageTitle.equalsIgnoreCase("Sign in to Outlook")) {
            usernamePage.enterUserName();
            WaitUtils.staticWait(2000);
            usernamePage.clickSubmitButton();
        }
    }
    @Test(priority = 2, description = "Entering password into password textbox", dependsOnMethods = "firstTest")
    public static void thirdTest() {
        String pageTitle = windowHandleUtility.returnPageTitle();

        if(pageTitle.equalsIgnoreCase("Sign in to Outlook")) {
            usernamePage.enterUserName();
            WaitUtils.staticWait(2000);
            usernamePage.clickSubmitButton();
        }
    }

    @Test(priority = 3, description = "Entering password into password textbox", dependsOnMethods = "firstTest")
    public static void fourthTest() {
        String pageTitle = windowHandleUtility.returnPageTitle();

        if(pageTitle.equalsIgnoreCase("Sign in to Outlook")) {
            passwordPage.enterPassword();
            WaitUtils.staticWait(2000);
            passwordPage.clickSubmitButton();
        }
    }
}
