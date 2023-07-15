package Domaci.Zadatak3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithCookies {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/books");

        Cookie loginCookie1 = new Cookie("userName", "ivana2909");
        Cookie loginCookie = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Iml2YW5hMjkwOSIsInBhc3N3b3JkIjoiS3JvZm5hMTIzISIsImlhdCI6MTY4NjA4NjY2Nn0._YrfzshurM3au2zH5MHhKyHp0s-PYkuTnO803oKZpGI");
        Cookie loginCookie2 = new Cookie("expires", "2023-06-13T21%3A24%3A26.350Z");
        driver.manage().addCookie(loginCookie);
        driver.manage().addCookie(loginCookie2);
        driver.manage().addCookie(loginCookie1);
        driver.navigate().refresh();


        driver.manage().deleteAllCookies();
        driver.navigate().refresh();


    }
}
