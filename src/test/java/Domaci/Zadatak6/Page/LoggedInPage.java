package Domaci.Zadatak6.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {
    public WebDriver driver;
    WebElement poruka;
    String URLstranice;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPoruka() {
        return driver.findElement(By.id("content"));
    }

    public String getURLstranice() {
        return driver.getCurrentUrl();
    }
}
