package Domaci.Zadatak10.Pages;

import Domaci.Zadatak10.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBar extends BaseTest {

    public SideBar() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "text")
    public List<WebElement> buttons;

    public void clickOnButton(String name) {
        for (WebElement sideBarButton : buttons) {
            if (sideBarButton.getText().equals(name)) {
                sideBarButton.click();
                break;
            }
        }
    }
}

