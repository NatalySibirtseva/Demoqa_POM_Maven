package demoqa.pages.interactions;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "draggable")
    WebElement draggableMe;

    @FindBy(id = "droppable")
    WebElement droppableHere;

    public DroppablePage actionDragMe() {
        pause(1000);
        moveWithJs(0, 300);
        new Actions(driver).dragAndDrop(draggableMe, droppableHere).perform();
        return this;
    }

    public DroppablePage verifyDropped(String text) {
        Assert.assertTrue(shouldHaveText(droppableHere, text, 5));
        return this;
    }
}
