package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {

    public static WebDriver driver;
    public static String baseURL = "https://staging.cicle.app";

    public static void initDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions o = new ChromeOptions();
        o.addArguments("--incognito");
        driver = new ChromeDriver(o);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get(baseURL);
    }

    public static WebDriver getDriver(){
            initDriver();
        return driver;
    }

    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
