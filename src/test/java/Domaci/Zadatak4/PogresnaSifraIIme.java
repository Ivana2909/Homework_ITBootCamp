package Domaci.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PogresnaSifraIIme {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        String username = "Admin";
        String password = "Admin";

        String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),"https://Admin:admin@the-internet.herokuapp.com/basic_auth");


    }
}
