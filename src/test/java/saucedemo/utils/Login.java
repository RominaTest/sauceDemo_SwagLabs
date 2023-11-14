package saucedemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login {

    public static void testLogin(WebDriver driver, String username, String password) throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(new CharSequence[]{username.trim()});
        driver.findElement(By.id("password")).sendKeys(new CharSequence[]{password.trim()});
        driver.findElement(By.id("login-button")).click();
        String actualUrl="https://www.saucedemo.com/inventory.html";
        //String expectedUrl= driver.getCurrentUrl();
        //Assert.assertEquals(expectedUrl,actualUrl);

    }
}