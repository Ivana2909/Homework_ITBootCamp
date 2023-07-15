package Domaci.Zadatak7.Test;

import Domaci.Zadatak7.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class LogInTest extends BaseTest {
    String validUURL;
    String inValidURLUser;
    String inValidURLPass;
    String inValidURL;
    String URLstraniceLoggedIn;
    String URLstraniceLogIn;

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void userCanLogIn(){
        homePage.clickOnBasicAuth();

        logInPage.getURLValid();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Assert.assertTrue(loggedInPage.getPoruka().isDisplayed());
        URLstraniceLoggedIn=excelReader.getStringData("URL",1,0);
        Assert.assertEquals(driver.getCurrentUrl(),URLstraniceLoggedIn);

    }

    @Test
    public void userCannotLogInWithInvalidUsername(){
        homePage.clickOnBasicAuth();
        logInPage.getURLInvalidUser();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // Assert.assertFalse(elementIsPresent(loggedInPage.getPoruka())); --> ne radi mi element is present! Ne znam jos uvek zasto...
        URLstraniceLogIn=excelReader.getStringData("URL",1,1);
        Assert.assertEquals(driver.getCurrentUrl(),URLstraniceLogIn);
        System.out.println(URLstraniceLogIn);
    }
    @Test
    public void userCannotLogInWithInvalidPassword(){
        homePage.clickOnBasicAuth();
        logInPage.getURLInvalidPass();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

       // Assert.assertFalse(elementIsPresent(loggedInPage.getPoruka()));
       URLstraniceLogIn=excelReader.getStringData("URL",1,2);
       Assert.assertEquals(driver.getCurrentUrl(),URLstraniceLogIn);
    }
    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword(){
        homePage.clickOnBasicAuth();
        logInPage.getURLInvalid();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // Assert.assertFalse(elementIsPresent(loggedInPage.getPoruka()));
        URLstraniceLogIn=excelReader.getStringData("URL",1,3);
        Assert.assertEquals(driver.getCurrentUrl(),URLstraniceLogIn);
    }


}
