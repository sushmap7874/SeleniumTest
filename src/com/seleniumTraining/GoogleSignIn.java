package com.seleniumTraining;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


import java.util.concurrent.TimeUnit;

public class GoogleSignIn {
    public static void main(String[] args) {
        // write your code here
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
        driver.findElement(By.cssSelector("input[type=\"email\"]")).isDisplayed();
        driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("patel.sushma@tftus.com");
        driver.findElement(By.cssSelector("span.CwaK9")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"password\"]")));
        driver.findElement(By.cssSelector("input[type=\"password\"]")).isDisplayed();
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Tftus@123");
        driver.findElement(By.cssSelector("span.CwaK9")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.x7WrMb")));
        WebElement element = driver.findElement(By.cssSelector("h1.x7WrMb"));
        String expectedText = element.getText();
        Assert.assertEquals("Logged in user name shows on welcome page", expectedText, "Welcome, Sushma Patel");
        driver.close();
    }
}
