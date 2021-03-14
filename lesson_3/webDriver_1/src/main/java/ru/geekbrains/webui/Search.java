package ru.geekbrains.webui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static ru.geekbrains.webui.LoginPage.driver;
import static ru.geekbrains.webui.LoginPage.login;

public class Search {
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        LoginPage.driver = new ChromeDriver(options);
        LoginPage.driver.manage().window().maximize();

        LoginPage.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        login();

        WebDriverWait driverWait = new WebDriverWait(LoginPage.driver, 5);

        driverWait.until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.cssSelector(".gb-top-menu__item > .show-search-form > .svg-icon")))).click();

        new WebDriverWait(LoginPage.driver, 5).until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.xpath("//*[@class=\"search-panel__form ng-pristine ng-valid\"]/input[@name=\"q\"]"))))
                .sendKeys("java");

        new WebDriverWait(LoginPage.driver, 5).until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.xpath("//*[@class=\"profession-row-1\"]/div[2]"))));

        driver.quit();
    }
}
