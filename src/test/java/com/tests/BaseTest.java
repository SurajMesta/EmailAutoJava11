package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import static Utils.PropertyUtils.*;

public class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static String url = "";

    static {
        String browser = getValue("browser_name");
        String url = getValue("web_url");
        System.out.println(url);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            driver.get().get(url);
            if(getValue("full_screen").equalsIgnoreCase("yes")){
                driver.get().manage().window().maximize();
            }

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
            driver.get().get(url);
            if(getValue("full_screen").equalsIgnoreCase("yes")){
                driver.get().manage().window().maximize();
            }
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver.set(new SafariDriver());
            driver.get().get(url);
            if(getValue("full_screen").equalsIgnoreCase("yes")){
                driver.get().manage().window().maximize();
            }
        } else {
            System.out.println("Please choose between the following browsers.....");
            System.out.println("Available browsers are chrome,firefox & safari");

        }
    }



    public static WebDriver getDriver() {
        if (driver.get() != null) {
            return driver.get();
        } else {
            return null;
        }
    }

}
