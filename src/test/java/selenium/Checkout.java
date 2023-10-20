package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Checkout {
    @Test
    public void checkout_single_item() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();
        //apply chrome driver setup
        driver = new ChromeDriver(); //Bisa diubah sesuai browser
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Assert logo di page login
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        //input username
        driver.findElement(By.id("user-name")).sendKeys(new CharSequence[]{"standard_user"});
        //input password
        driver.findElement(By.id("password")).sendKeys(new CharSequence[]{"secret_sauce"});
        //click login
        driver.findElement(By.id("login-button")).click();
        //Assert Logo setelah login
        String mainPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(mainPageAssert, "Swag Labs");
        //Click Add to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //Click cart icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        //Assert cart page
        String cartPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(cartPageAssert, "Your Cart");
        //Assert item
        String cartItemAssert = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(cartItemAssert, "Sauce Labs Backpack");
        //Click checkout button
        driver.findElement(By.id("checkout")).click();
        //Assert checkout information page
        String checkoutInfoAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(checkoutInfoAssert, "Checkout: Your Information");
        //Input firstname, lastname,postal code
        driver.findElement(By.id("first-name")).sendKeys(new CharSequence[]{"Shandy"});
        driver.findElement(By.id("last-name")).sendKeys(new CharSequence[]{"Nugraha"});
        driver.findElement(By.id("postal-code")).sendKeys(new CharSequence[]{"40624"});
        //Click continue button
        driver.findElement(By.id("continue")).click();
        //Assert checkout overview page
        String checkoutOverviewAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(checkoutOverviewAssert, "Checkout: Overview");
        //Click finish button
        driver.findElement(By.id("finish")).click();
        //Assert checkout success
        WebElement imageCheck = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/img"));
        Boolean imagePresent = imageCheck.isDisplayed();
        Assert.assertTrue(imagePresent);
        //Close browser
        driver.close();
    }
}
