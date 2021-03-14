package ru.geekbrains.webui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    protected static WebDriver driver;
    protected static final String GB_URL = "https://geekbrains.ru/";
    protected static final String USER_LOGIN = "so@ova777.ru";
    protected static final String USER_PASSWORD = "Briv31So2";

    protected static void login() {
        driver.get(GB_URL);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//*[@id=\"gb-analytics-sign-in\"]")))).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//*[@id=\"user_email\"]")))).sendKeys(USER_LOGIN);

        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys(USER_PASSWORD);

        driver.findElement(By.cssSelector(".btn")).click();
    }
}
