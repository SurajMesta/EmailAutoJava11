package TestUtils;

import org.jspecify.annotations.Nullable;

import static com.tests.BaseTest.*;

import java.util.Iterator;
import java.util.Set;

public final class WindowHandleUtility {
    private WindowHandleUtility() {
    }

    private static WindowHandleUtility windowHandleUtility = null;

    public static WindowHandleUtility getInstance() {
        if (windowHandleUtility == null) {
            windowHandleUtility = new WindowHandleUtility();
        } else {
            return windowHandleUtility;
        }
        return windowHandleUtility;

    }

    public  String returnPageTitle() {
        Set<String> windows = getDriver().getWindowHandles();
        Iterator<String> it = windows.iterator();
        String value = "";
        String title = "";
        while (it.hasNext()) {
            value = it.next();
            System.out.println(value);
            getDriver().switchTo().window(value);
            title = getDriver().getTitle();
        }

        return title;
    }
}
