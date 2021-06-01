package com.seleniumTraining;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class SeleniumAssignment3 {
    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[title=\"Search\"]")));
        WebElement txtSearch = driver.findElement(By.cssSelector("input[title=\"Search\"]"));
        Actions builder = new Actions(driver);
        Action keyboardAction = builder
                .moveToElement(txtSearch)
                .click()
                .sendKeys(txtSearch, "gmail")
                .build();

        keyboardAction.perform();
        Thread.sleep(3000);

        WebElement autoKeywordElement = driver.findElement(By.cssSelector("ul.erkvQe > li:nth-child(2)"));
        Action mouseClickOption = builder
                .moveToElement(autoKeywordElement)
                .click()
                .build();
        mouseClickOption.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rso > div:nth-child(1) > div > div > div.r > a > h3")));
        WebElement resultElement = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.r > a > h3"));
        String expectedResult = resultElement.getText();
        System.out.println(expectedResult);
        String actualResult = "Google Login - Sign in - Google Accounts";
        Assert.assertEquals("Verified the first result shows as expected", expectedResult, actualResult);
        driver.close();
    }
}
