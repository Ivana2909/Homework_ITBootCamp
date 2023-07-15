package Domaci.Zadatak7.Base;

import Domaci.Zadatak6.Page.HomePage;
import Domaci.Zadatak6.Page.LogInPage;
import Domaci.Zadatak6.Page.LoggedInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {
    //    // uraditi POM za sto vise funkcija logovanja na sajtu https://the-internet.herokuapp.com/ sa ExcelReaderom

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public LogInPage logInPage;
    public LoggedInPage loggedInPage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        homePage=new HomePage(driver);
        logInPage=new LogInPage(driver);
        loggedInPage=new LoggedInPage(driver);
        excelReader=new ExcelReader("C:\\Users\\ivana\\OneDrive\\Desktop\\TestData.xlsx");
    }
    public boolean elementIsPresent(WebElement element){
        boolean nonexistingElement=false;
        try{
            nonexistingElement=element.isDisplayed();
        }catch(Exception e){
        }
        return nonexistingElement;
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
