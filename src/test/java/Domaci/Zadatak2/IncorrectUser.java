package Domaci.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class IncorrectUser {
    //Pokriti sve negativne case-eve za login (Napraviti posebnu klasu za svaki case gde ne prolazi log-in). https://practicetestautomation.com/

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement testLogIn = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a"));
        testLogIn.click();

        String validUsername = "student";
        String incorrectUser = "incorrectUser";
        String validPassword = "Password123 ";
        String incorrectPassword = "incorrectPassword ";

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(incorrectUser);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(validPassword);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement error= driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());

        String errorText="Your username is invalid!";

        Assert.assertEquals(error.getText(),errorText);
    }

}
