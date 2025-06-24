package demoqa.pages;

import demoqa.core.BasePage;
import demoqa.pages.alertsFrameWindows.AlertsPage;
import demoqa.pages.alertsFrameWindows.BrowserWindowsPage;
import demoqa.pages.alertsFrameWindows.FramePage;
import demoqa.pages.forms.PracticeFormPage;
import demoqa.pages.interactions.DroppablePage;
import demoqa.pages.widgets.MenuPage;
import demoqa.pages.widgets.SelectMenuPage;
import demoqa.pages.widgets.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        click(login);
        return new LoginPage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts, 0, 300);
        return new AlertsPage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public SidePanel selectFrames() {
        click(frames, 0, 300);
        //return this;
        return new SidePanel(driver, wait);
    }
    //ostalis na side panel tut, tak kak dolzno bit tut podmenu, no ego ne sdelali. A testi delaem kak budto est

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public FramePage selectNestedFrames() {
        click(nestedFrames);
        return new FramePage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindowsPage selectBrowserWindows() {
        click(browserWindows);
        return new BrowserWindowsPage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        click(selectMenu, 0, 500);
        return new SelectMenuPage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage getMenu() {
        click(menu, 0, 500);
        return new MenuPage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        click(slider, 0, 300);
        return new SliderPage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public DroppablePage selectDroppable() {
        click(droppable, 0, 300);
        return new DroppablePage(driver, wait);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm, 0, 200);
        return new PracticeFormPage(driver, wait);
    }
}
