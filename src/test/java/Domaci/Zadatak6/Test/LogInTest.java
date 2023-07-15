package Domaci.Zadatak6.Test;

import Domaci.Zadatak6.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInTest extends BaseTest {

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
       Assert.assertEquals(driver.getCurrentUrl(),loggedInPage.getURLstranice());
       System.out.println(logInPage.getURLstranice());
       System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void userCannotLogInWithInvalidUsername(){
        homePage.clickOnBasicAuth();
        logInPage.getURLInvalidUser();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),logInPage.getURLstranice());
    }
    @Test
    public void userCannotLogInWithInvalidPassword(){
        homePage.clickOnBasicAuth();
        logInPage.getURLInvalidPass();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),logInPage.getURLstranice());
    }
    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword(){
        homePage.clickOnBasicAuth();
        logInPage.getURLInvalid();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),logInPage.getURLstranice());
    }


}
