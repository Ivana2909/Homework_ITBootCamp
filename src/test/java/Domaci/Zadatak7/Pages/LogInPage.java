package Domaci.Zadatak7.Pages;

import Domaci.Zadatak7.Base.BaseTest;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BaseTest {
    String validUsername=excelReader.getStringData("UserAndPassword",1,0);
    String   validPassword=excelReader.getStringData("UserAndPassword",1,1);
    String invalidUser=excelReader.getStringData("UserAndPassword",1,2);
    String invalidPass=excelReader.getStringData("UserAndPassword",1,3);;

    WebDriver driver;
    String URLValid;
    String URLInvalidUser;
    String URLInvalidPass;
    String URLInvalid;


    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getURLValid() {
        driver.get("https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth");
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
