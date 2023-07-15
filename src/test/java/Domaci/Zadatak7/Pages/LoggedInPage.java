package Domaci.Zadatak7.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {
    public WebDriver driver;
    WebElement poruka;


    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPoruka() {
        return driver.findElement(By.id("content"));
    }


}
