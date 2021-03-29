package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;


public class TestBase {
    protected WebDriver driver = Hooks.getDriver();
    protected HomePage homepage = PageFactory.initElements(driver, HomePage.class);
    //protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    //protected AccountPage accountPage = PageFactory.initElements(driver, AccountPage.class);
}
