package Domaci.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UspesnoLogovanje {
    //Otici na sajt Herkouapp(https://the-internet.herokuapp.com/) i napisati sto vise test case-eva za log-in fun
    //kciju (Basic Auth).

    // https://the-internet.herokuapp.com/


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        String username = "admin";
        String password = "admin";

        String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement poruka= driver.findElement(By.id("content"));
        Assert.assertTrue(poruka.isDisplayed());

        Assert.assertEquals(driver.getCurrentUrl(), "https://admin:admin@the-internet.herokuapp.com/basic_auth");


    }
}
