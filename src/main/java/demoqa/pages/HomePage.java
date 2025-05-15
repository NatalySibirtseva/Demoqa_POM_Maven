package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePanel getBookStore() {
        //click(bookStore);
        click(bookStore, 0, 500);
        return new SidePanel(driver, wait);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePanel getAlertsFrameWindows() {
        click(alertsFrameWindows, 0, 400);
        return new SidePanel(driver, wait);
    }

    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;

    public SidePanel getWidgets() {
        click(widgets, 0, 400);
        return new SidePanel(driver, wait);
    }

    @FindBy(css = ".top-card:nth-child(5)")
    WebElement interactions;

    public SidePanel getInteractions() {
        click(interactions, 0, 400);
        return new SidePanel(driver,wait);
    }
}
