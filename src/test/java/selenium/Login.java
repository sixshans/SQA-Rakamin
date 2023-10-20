package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void login_success_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver(); //Bisa diubah sesuai browser
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //Assert logo di page login
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();
        //Assert Logo setelah login
        String mainPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(mainPageAssert,"Swag Labs");
        //Quit
        driver.close();
    }
    @Test
    public void login_failed_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver(); //Bisa diubah sesuai browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
        driver.get(baseUrl);
        //Assert logo di page login
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("12345");
        //click login
        driver.findElement(By.id("login-button")).click();
        //Assert error message
        String loginErrorSign = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(loginErrorSign,"Epic sadface: Username and password do not match any user in this service");
        //Quit
        driver.close();
    }
}
