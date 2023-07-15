package Domaci.Zadatak10.Test;

import Domaci.Zadatak10.Base.BaseTest;
import Domaci.Zadatak10.Pages.ButtonsPage;
import Domaci.Zadatak10.Pages.HomePage;
import Domaci.Zadatak10.Pages.SideBar;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTest {

    public SideBar sideBar;
    public HomePage homePage;
    public ButtonsPage buttonsPage;

    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        homePage = new HomePage();
        sideBar = new SideBar();
        buttonsPage = new ButtonsPage();
        driver.get(homeURL);
        homePage.clickOnElementsCard();
        js.executeScript("window.scrollBy(0, 250)", "");
        sideBar.clickOnButton("Buttons");
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void doubleClickMe() {
        buttonsPage.doubleClickOnButton();
        Assert.assertTrue(buttonsPage.doubleClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), "You have done a double click");
    }

    @Test(priority = 20)
    public void rightClickMe() {
        buttonsPage.rightClickOnButton();
        Assert.assertTrue(buttonsPage.rightClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), "You have done a right click");
    }

    @Test(priority = 30)
    public void clickMe() {
        buttonsPage.clickOnClickButton();
        Assert.assertTrue(buttonsPage.dynamicClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(), "You have done a dynamic click");
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}