package TestUtils;

import static com.tests.BaseTest.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static TestUtils.WaitUtils.*;

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

    public static void moveToElementAndClick(WebElement element){
        getInstance().moveToElement(element).click().build().perform();
    }

}
