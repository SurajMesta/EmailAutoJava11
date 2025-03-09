package TestUtils;

import static com.tests.BaseTest.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public final class ActionUtils {

    private ActionUtils() {
    }

    private static Actions actions = null;

    public static Actions getInstance() {
        if (actions == null) {
            actions = new Actions(getDriver());
        } else {
            return actions;
        }
        return actions;
    }

    public static void moveToElementAndClick(WebElement element) {
        getInstance().moveToElement(element).click().build().perform();
    }

    public static void enterValueToTextBox(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }
}
