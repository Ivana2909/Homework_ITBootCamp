package Domaci.Zadatak6.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

    String validUsername = "admin";
    String validPassword = "admin";
    String invalidUser="Admin";
    String invalidPass="Admin";

    WebDriver driver;
    String URLValid;
    String URLInvalidUser;
    String URLInvalidPass;
    String URLInvalid;
    String URLstranice;


    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getURLValid() {
        driver.get("https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth");
    }

    public String getURLstranice() {
        return driver.getCurrentUrl();
    }
    public String getValidUsername() {
        return validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void getURLInvalidUser() {
        driver.get("https://" + invalidUser + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth");
    }

    public void getURLInvalidPass() {
        driver.get("https://" + validUsername + ":" + invalidPass + "@" + "the-internet.herokuapp.com/basic_auth");
    }

    public void getURLInvalid() {
        driver.get("https://" + invalidUser + ":" + invalidPass + "@" + "the-internet.herokuapp.com/basic_auth");
    }
}
