package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {
    @Test
    public void cart_add_single_item() {
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
        //Close browser
        driver.close();
    }

    @Test
    public void cart_add_multiple_item() {
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
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        //Click cart icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        //Assert cart page
        String cartPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(cartPageAssert, "Your Cart");
        //Assert item
        String cartItemAssert1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        String cartItemAssert2 = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).getText();
        String cartItemAssert3 = driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText();
        Assert.assertEquals(cartItemAssert1, "Sauce Labs Backpack");
        Assert.assertEquals(cartItemAssert2, "Sauce Labs Bike Light");
        Assert.assertEquals(cartItemAssert3, "Sauce Labs Bolt T-Shirt");
        //Close browser
        driver.close();
    }

    @Test
    public void cart_remove_item() {
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
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        //Click cart icon
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        //Assert cart page
        String cartPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(cartPageAssert, "Your Cart");
        //Assert item
        String cartItemAssert1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(cartItemAssert1, "Sauce Labs Backpack");
        //Remove item
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
        //Assert item after remove
//        if(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed()){
//            System.out.println("The item still present");
//        }
//        else {
//            Assert.fail("The item not present");
//        }
        //Close browser
        driver.close();
    }
}
