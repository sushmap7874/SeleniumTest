package com.seleniumTraining;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SeleniumAssignment2 {
    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        String navigateUrl = "http://seleniumhq.github.io/selenium/docs/api/java/index.html";
        driver.get(navigateUrl);
        Random random = new Random();
        driver.switchTo().frame("packageListFrame");
        String packageLocator = ".indexContainer> ul[title=\"Packages\"]> li > a";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(packageLocator)));
        List<WebElement> packageElements = driver.findElements(By.cssSelector(packageLocator));
        int randomPackage = 1 + random.nextInt(packageElements.size());
        WebElement packageElement = packageElements.get(randomPackage);
        String getPackage = packageElement.getText();
        packageElement.click();
        System.out.println(getPackage);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("packageFrame");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar > a")));
        WebElement selectPackageElement = driver.findElement(By.cssSelector(".bar > a"));
        String selectPackage = selectPackageElement.getText();
        Assert.assertEquals("Verified selected package shows in all classes section", selectPackage, getPackage);

        String classesLocator = "ul[title=\"Classes\"] > li > a";
        List<WebElement> classesElements =  driver.findElements(By.cssSelector(classesLocator));
        int randomClass = 1 + random.nextInt(classesElements.size());
        WebElement classesElement = classesElements.get(randomClass);
        String getClass = classesElement.getText();
        System.out.println(getClass);
        classesElement.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("classFrame");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header > h2")));
        WebElement selectClassElement = driver.findElement(By.cssSelector(".header > h2"));
        String selectClass = selectClassElement.getText().split("\\s+", 2)[1];
        System.out.println(selectClass);
        Assert.assertEquals("Verified selected class shows in header", selectClass, getClass);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.summary > ul > li > ul:nth-child(1) > li > h3")));
        driver.findElement(By.cssSelector("div.summary > ul > li > ul:nth-child(1) > li > h3")).isDisplayed();
        WebElement fieldElement = driver.findElement(By.cssSelector("div.summary > ul > li > ul:nth-child(1) > li > h3"));
        if (fieldElement.getText().equals("Field Summary")) {
            List<WebElement> fieldsElements = driver.findElements(By.cssSelector("div.summary > ul > li > ul:nth-child(1) > li > table > tbody > tr > td:nth-child(2) > code > span > a"));
            for(WebElement element: fieldsElements) {
                System.out.println("Fields are = " + element.getText());
            }
        } else if (fieldElement.getText().equals("Constructor Summary")){
            List<WebElement> constructorElements = driver.findElements(By.cssSelector("div.summary > ul > li > ul:nth-child(1) > li > table > tbody > tr > td > code > span > a"));
            for(WebElement element: constructorElements) {
                System.out.println("Constructors are = " + element.getText());
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.summary > ul > li > ul:nth-child(2) > li > h3")));
        driver.findElement(By.cssSelector("div.summary > ul > li > ul:nth-child(2) > li > h3")).isDisplayed();
        WebElement constructorElement = driver.findElement(By.cssSelector("div.summary > ul > li > ul:nth-child(2) > li > h3"));
        if (constructorElement.getText().equals("Constructor Summary")) {
            List<WebElement> constructorElements = driver.findElements(By.cssSelector("div.summary > ul > li > ul:nth-child(2) > li > table > tbody > tr > td > code > span > a"));
            for(WebElement element: constructorElements) {
                System.out.println("Constructors are = " + element.getText());
            }
        } else if (constructorElement.getText().equals("Method Summary")){
            List<WebElement> methodsElements = driver.findElements(By.cssSelector("div.summary > ul > li > ul:nth-child(2) > li > table > tbody > tr > td > code > span > a"));
            for(WebElement element: methodsElements) {
                System.out.println("Methods are = " + element.getText());
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.summary > ul > li > ul:nth-child(3) > li > h3")));
        boolean methodsLocator = driver.findElement(By.cssSelector("div.summary > ul > li > ul:nth-child(3) > li > h3")).isDisplayed();
        if (methodsLocator) {
            WebElement methodsElement = driver.findElement(By.cssSelector("div.summary > ul > li > ul:nth-child(3) > li > h3"));
            if (methodsElement.getText().equals("Method Summary")) {
                List<WebElement> methodsElements = driver.findElements(By.cssSelector("div.summary > ul > li > ul:nth-child(3) > li > table > tbody > tr > td > code > span > a"));
                for(WebElement element: methodsElements) {
                    System.out.println("Methods are = " + element.getText());
                }
            }
        }

        driver.close();
    }
}
