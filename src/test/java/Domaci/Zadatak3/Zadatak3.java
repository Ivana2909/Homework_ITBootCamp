/*package Domaci.Zadatak3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak3 {

    //Domaci Zadatak 2:
    //Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjig
    //e na svoj nalog, zatim se izlogovati brisanjem cookies-a.
    //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/books");

        WebElement loginDugme = driver.findElement(By.id("login"));
        loginDugme.click();
        String validName = "ivana2909";
        String validPassword = "Krofna123!";
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys(validName);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(validPassword);

        WebElement loginDugme2 = driver.findElement(By.id("login"));
        loginDugme2.click();

        Thread.sleep(3000);
        WebElement userProvera = driver.findElement(By.id("userName-value"));

        Assert.assertEquals(userProvera.getText(), validName);

        WebElement logOutDugme = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutDugme.isDisplayed());

        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        knjiga1.click();

        Thread.sleep(3000);
        WebElement ubaciKnjigu = driver.findElement(By.cssSelector(".text-right.fullButton"));
        ubaciKnjigu.click();

        Alert alt = driver.switchTo().alert();
        alt.accept();

        Thread.sleep(3000);
        WebElement idiNaBookStore = driver.findElement(By.cssSelector(".text-left.fullButton"));
        idiNaBookStore.click();

        WebElement knjiga2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        knjiga2.click();

        Thread.sleep(5000);
        ubaciKnjigu.click();

        Thread.sleep(5000);

        alt.accept();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();


    }
}
*/