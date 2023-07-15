package Domaci.Zadatak10.Test;

import Domaci.Zadatak10.Base.BaseTest;
import Domaci.Zadatak10.Pages.HomePage;
import Domaci.Zadatak10.Pages.RadioButtonPage;
import Domaci.Zadatak10.Pages.SideBar;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        radioButtonPage = new RadioButtonPage();
        driver.get(homeURL);
        homePage.clickOnElementsCard();
        sideBar.clickOnButton("Radio Button");
    }

    @Test(priority = 10)
    public void clickOnYes() {
        radioButtonPage.clickOnYesRadio();
        Assert.assertTrue(radioButtonPage.yesRadio.isSelected());
        Assert.assertTrue(radioButtonPage.message.isDisplayed());
        Assert.assertEquals(radioButtonPage.message.getText(), "Yes");
    }

    @Test(priority = 20)
    public void clickOnImpressive() {
        radioButtonPage.clickOnImpressiveRadio();
        Assert.assertTrue(radioButtonPage.impressiveRadio.isSelected());
        Assert.assertTrue(radioButtonPage.message.isDisplayed());
        Assert.assertEquals(radioButtonPage.message.getText(), "Impressive");
    }

    @Test(priority = 30)
    public void clickOnNo() throws Exception {
        radioButtonPage.clickOnNoRadio();
        Assert.assertFalse(radioButtonPage.noRadio.isSelected());
        Assert.assertFalse(elementIsPresent(radioButtonPage.message));
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}
