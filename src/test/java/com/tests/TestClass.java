package com.tests;


import POM.WelcomePage;
import static TestUtils.WaitUtils.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {
    private static WelcomePage welcomePage;
    @BeforeSuite
    public void setUpMethod(){
        welcomePage= WelcomePage.getInstance();
    }

    @AfterSuite
    public void tearDown(){
        staticWait(5000);
        getDriver().quit();
    }


    @Test(priority = 0, description = "Logging in to outlook by clicking sign-in button")
    public static void firstTest() {
        welcomePage.clickSignInButton();
    }
}
