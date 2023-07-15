package Domaci.Zadatak6.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;
    WebElement basicAuth;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBasicAuth() {
        return driver.findElement(By.linkText("Basic Auth"));
    }

    //------------------------------------------

    public void clickOnBasicAuth(){
        getBasicAuth().click();
    }
}
