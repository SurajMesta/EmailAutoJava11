package POM;

import static com.tests.BaseTest.*;

import TestUtils.ActionUtils;
import TestUtils.WaitUtils;
import Utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static TestUtils.ActionUtils.*;

public final class UsernamePage {
    private static UsernamePage usernamePage = null;

    private UsernamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static UsernamePage getInstance() {
        if (usernamePage == null) {
            usernamePage = new UsernamePage(getDriver());
        } else {
            return usernamePage;
        }
        return usernamePage;
    }

    @FindBy(xpath = "//div/div/input[@type='email']")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;


    public void enterUserName() {
        WebDriverWait wait = WaitUtils.dynamicWait(2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/input[@type='email']")));
        ActionUtils.enterValueToTextBox(userNameTextBox, PropertyUtils.getValue("USERNAME"));
    }

    public void clickSubmitButton() {
        WebDriverWait wait = WaitUtils.dynamicWait(2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        ActionUtils.clickElement(submitButton);
    }
}
