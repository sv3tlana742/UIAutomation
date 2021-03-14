package ru.geekbrains.webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static ru.geekbrains.webui.LoginPage.driver;
import static ru.geekbrains.webui.LoginPage.login;

public class CoursesFree {
    static {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        LoginPage.driver = new ChromeDriver(options);

        LoginPage.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        login();

        new WebDriverWait(LoginPage.driver, 5).until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.cssSelector(".gb-left-menu__nav-item > .icon-courses")))).click();

        new WebDriverWait(LoginPage.driver, 5).until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.cssSelector(".nav #cour-link")))).click();

        new WebDriverWait(LoginPage.driver, 5).until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.xpath("//*[@class=\"courses-filter js-courses-filter ng-pristine ng-valid\"]")))).click();

        new WebDriverWait(LoginPage.driver, 5).until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.cssSelector(".list-group-item:nth-child(1) label")))).click();

        new WebDriverWait(LoginPage.driver, 5).until(ExpectedConditions.visibilityOf(LoginPage.driver.findElement
                (By.xpath("//*[@id=\"courses-tab\"]/div/a/div[2]/div"))));

        driver.quit();
    }
}
