package POM;

import TestUtils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.tests.BaseTest.*;
import static TestUtils.ActionUtils.*;

public final class WelcomePage {

    private WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private static WelcomePage welcomePage = null;

    public static WelcomePage getInstance() {
        if (welcomePage == null) {
            welcomePage = new WelcomePage(getDriver());
            return welcomePage;
        } else {
            return welcomePage;
        }
    }

    @FindBy(xpath = "//div/div/div/nav/ul/li/a[@class='c-uhf-nav-link' and text()='Sign in'][1]")
    private WebElement signInButton;

//    @FindBy(css="li > #c-shellmenu_custom_outline_newtab_signin_bhvr100")
//    private WebElement signInButton;

    public void clickSignInButton() {
        WebDriverWait wait = WaitUtils.dynamicWait(2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/nav/ul/li/a[@class='c-uhf-nav-link' and text()='Sign in'][1]")));
        moveToElementAndClick(signInButton);
    }
}
