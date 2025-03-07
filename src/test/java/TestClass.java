import TestUtils.ActionUtils;
import com.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestClass extends BaseTest {

    public static void main(String[] args) {

        System.out.println(getDriver().getTitle());
        WebElement element = getDriver().findElement(By.xpath("//button[contains(text(),'Microsoft')]"));
        ActionUtils.moveToElementAndClick(element);
    }
}
