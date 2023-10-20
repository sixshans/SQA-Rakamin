package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class stepCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User on main page with item displayed")
    public void userOnMainPageWithItemDisplayed() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
        driver.get(baseUrl);

        //Assert logo di page login
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        //Input credential
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click login button
        driver.findElement(By.id("login-button")).click();
        //Assert main page
        String mainPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(mainPageAssert,"Swag Labs");
    }

    @And("Click item Add to Cart button")
    public void clickItemAddToCartButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @When("Click Cart icon")
    public void clickCartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And("User on cart page")
    public void userOnCartPage() {
        String cartPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(cartPageAssert, "Your Cart");
    }

    @Then("The item is listed in the Cart page")
    public void theItemIsListedInTheCartPage() {
        String cartItemAssert = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(cartItemAssert, "Sauce Labs Backpack");
        driver.close();
    }

    @And("Click second item Add to Cart")
    public void clickSecondItemAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("Click third item Add to Cart")
    public void clickThirdItemAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @Then("The items is listed in the Cart page")
    public void theItemsIsListedInTheCartPage() {
        String cartItemAssert1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        String cartItemAssert2 = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).getText();
        String cartItemAssert3 = driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText();
        Assert.assertEquals(cartItemAssert1, "Sauce Labs Backpack");
        Assert.assertEquals(cartItemAssert2, "Sauce Labs Bike Light");
        Assert.assertEquals(cartItemAssert3, "Sauce Labs Bolt T-Shirt");
        driver.close();
    }

    @When("Click remove button")
    public void clickRemoveButton() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
    }

    @Then("The item was removed is not listed in the Cart page")
    public void theItemWasRemovedIsNotListedInTheCartPage() {
        String cartItemAssert1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(cartItemAssert1, "Sauce Labs Backpack");
        driver.close();
    }
}
