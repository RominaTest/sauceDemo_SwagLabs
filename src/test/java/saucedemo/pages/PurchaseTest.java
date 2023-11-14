package saucedemo.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.Constants;
import saucedemo.utils.Login;

import java.util.List;

public class PurchaseTest {

    @Test
    public void testCompletePurchase() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        Login.testLogin(driver, "standard_user","secret_sauce");
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class=\"inventory_item\"]"));

        for (WebElement webElement : elementList) {
            if (webElement.findElement(By.className("inventory_item_name")).getText().equals("Sauce Labs Bike Light")) {
                webElement.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
            }
        }

        driver.findElement(By.className("shopping_cart_badge")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys(Constants.FIRST_NAME);

        driver.findElement(By.id("last-name")).sendKeys(Constants.LAST_NAME);

        driver.findElement(By.id("postal-code")).sendKeys(Constants.POSTAL_CODE);

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        WebElement e = driver.findElement(By.className("complete-text"));

        String actualElementText = e.getText();

        String expectedElementText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        Assert.assertEquals(actualElementText, expectedElementText,"Expected and Actual are not same");
        
        driver.close();

    }



}
