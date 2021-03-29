package test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    private static WebDriver driver;

    @Before()
    public void setup() {
    	 WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
    }

    @After()
    public void quitBrowser() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
