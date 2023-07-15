package Domaci.Zadatak6.Base;

import Domaci.Zadatak6.Page.HomePage;
import Domaci.Zadatak6.Page.LogInPage;
import Domaci.Zadatak6.Page.LoggedInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    // uraditi POM za sto vise funkcija logovanja na sajtu https://the-internet.herokuapp.com/

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public LogInPage logInPage;
    public LoggedInPage loggedInPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        homePage=new HomePage(driver);
        logInPage=new LogInPage(driver);
        loggedInPage=new LoggedInPage(driver);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
