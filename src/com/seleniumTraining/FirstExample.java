package com.seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExample {

    public static void main(String[] args) {
	// write your code here
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        String extualTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String expectedTitle = driver.getTitle();
        if(expectedTitle.equals(extualTitle)) {
            System.out.println("Pass");
            System.out.println(expectedTitle);
        }
        else {
            System.out.println("Fail");
        }
        boolean search = driver.findElement(By.name("site-search")).isDisplayed();
        System.out.println(search);
        driver.findElement(By.id("a-autoid-0-announce")).click();
        driver.close();
    }
}
