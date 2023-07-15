package Domaci.Zadatak5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Zadatak5 {
    WebDriver driver;
    String validUser;
    String validPassword;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void preTesta() throws InterruptedException {
        validUser = "ivana2909";
        validPassword = "Krofna123!";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        Thread.sleep(2000);
        List<WebElement> cards = driver.findElements(By.className("card-body"));
        for (int i = 0; i < cards.size(); i++) {
            scrollIntoView(cards.get(i));
            if (cards.get(i).getText().equals("Book Store Application")) {
                cards.get(i).click();
                break;
            }

        }
        Thread.sleep(2000);
        WebElement loginDugme = driver.findElement(By.id("login"));
        loginDugme.click();
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys(validUser);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(validPassword);

        WebElement loginDugme2 = driver.findElement(By.id("login"));
        loginDugme2.click();
        Thread.sleep(2000);
    }

    @Test
    public void dodavanjeKnjige1() throws InterruptedException {
        brisanjeSvihKnjiga();

        Thread.sleep(2000);
        WebElement backToStoreButton = driver.findElement(By.id("gotoStore"));
        scrollIntoView(backToStoreButton);
        backToStoreButton.click();

        Thread.sleep(2000);
        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        knjiga1.click();

        dodavanje();

        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        scrollIntoView(profile);
        profile.click();

        Thread.sleep(2000);
        WebElement knjiga1a = driver.findElement(By.id("see-book-Git Pocket Guide"));

        Assert.assertTrue(knjiga1a.isDisplayed());

        vracanje();

    }

    @Test
    public void dodavanjeKnjige2() throws InterruptedException {
        dodavanjeKnjige1();

        Thread.sleep(2000);
        WebElement knjiga2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        knjiga2.click();

        dodavanje();

        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        scrollIntoView(profile);
        profile.click();

        Thread.sleep(2000);
        WebElement knjiga2a = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));

        Assert.assertTrue(knjiga2a.isDisplayed());

        vracanje();
    }

    @Test
    public void dodavanjeKnjige3() throws InterruptedException {

        dodavanjeKnjige2();

        Thread.sleep(2000);
        WebElement knjiga3 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        knjiga3.click();

        dodavanje();
        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        scrollIntoView(profile);
        profile.click();

        Thread.sleep(2000);
        WebElement knjiga3a = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(knjiga3a.isDisplayed());

        vracanje();
    }

    @Test
    public void dodavanjeKnjige4() throws InterruptedException {

        dodavanjeKnjige3();

        Thread.sleep(2000);
        WebElement knjiga4 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        scrollIntoView(knjiga4);
        knjiga4.click();

        dodavanje();
        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        scrollIntoView(profile);
        profile.click();

        Thread.sleep(2000);
        WebElement knjiga4a = driver.findElement(By.id("see-book-Speaking JavaScript"));
        scrollIntoView(knjiga4);
        Assert.assertTrue(knjiga4a.isDisplayed());

        vracanje();

    }

    public void dodavanje() throws InterruptedException {

        Thread.sleep(2000);
        WebElement addBookButton = driver.findElement(By.cssSelector(".text-right.fullButton"));
        scrollIntoView(addBookButton);
        addBookButton.click();

        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }


    public void vracanje() throws InterruptedException {

        Thread.sleep(2000);
        WebElement backToStoreButton = driver.findElement(By.id("gotoStore"));
        scrollIntoView(backToStoreButton);
        backToStoreButton.click();
    }


    public void brisanjeSvihKnjiga() throws InterruptedException {

        WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        scrollIntoView(profile);
        profile.click();

        Thread.sleep(2000);
        WebElement deleteBooks = driver.findElement(By.cssSelector(".text-right.button.di"));
        scrollIntoView(deleteBooks);
        deleteBooks.click();

        WebElement okButton = driver.findElement(By.id("closeSmallModal-ok"));
        okButton.click();

        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
        // driver.navigate().refresh();
        //  profile.sendKeys(Keys.ESCAPE);


    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
