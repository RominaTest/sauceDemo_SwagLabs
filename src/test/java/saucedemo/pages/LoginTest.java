package saucedemo.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.utils.Login;
import saucedemo.utils.UserReader;

public class LoginTest extends UserReader {
    @Test(dataProvider = "LoginUser")
    public void testLogin(String username, String password) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Login.testLogin(driver, username, password);

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        if(username.equals("locked_out_user")){
            String errorText = driver.findElement(By.xpath("//h3[@data-test=\"error\"][contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")).getText();
            String errorLocked = "Epic sadface: Sorry, this user has been locked out.";
            Assert.assertEquals(errorLocked,errorText);
        }else{
            String actualUrl= driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl,actualUrl);
        }

        driver.close();
    }

}
