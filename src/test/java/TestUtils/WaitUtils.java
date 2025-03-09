package TestUtils;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.tests.BaseTest.*;

public final class WaitUtils {
    private WaitUtils(){};

    public static void staticWait(int value){
        try{
            Thread.sleep(value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static WebDriverWait dynamicWait(int value){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(value));
        return wait;
    }
}
