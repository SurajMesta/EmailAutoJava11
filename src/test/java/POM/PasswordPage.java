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

public final class PasswordPage {
    private static PasswordPage passwordPage=null;
    private PasswordPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public static PasswordPage getInstance() {
        if (passwordPage == null) {
            passwordPage = new PasswordPage(getDriver());
        } else {
            return passwordPage;
        }
        return passwordPage;
    }

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void enterPassword() {
        WebDriverWait wait = WaitUtils.dynamicWait(2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='passwd']")));
        ActionUtils.enterValueToTextBox(passwordTextBox, PropertyUtils.getValue("PASSWORD"));
    }

    public void clickSubmitButton() {
        WebDriverWait wait = WaitUtils.dynamicWait(2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        ActionUtils.clickElement(submitButton);
    }
}
