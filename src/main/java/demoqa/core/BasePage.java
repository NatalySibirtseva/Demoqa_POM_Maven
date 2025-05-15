package demoqa.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public static JavascriptExecutor js;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this); //в pom ispolzuem PageFactory dlya poiska elementov
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(WebElement element, int x, int y) {
        //element.click();
        //js.executeScript("window.scrollBy(" + x + "," + y + ") ");
        //js.executeScript("window.scrollBy({},{})", x, y);
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        click(element);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear(); //if tak kak clear ne mozet rabotat s null
            element.sendKeys(text);
        }
    }

    public void type(WebElement element, String text, int y) {
        if (text != null) {
            click(element, 0, y);
            element.clear(); //if tak kak clear ne mozet rabotat s null
            element.sendKeys(text);
        }
    }

    public void moveWithJs(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ") ");
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideAds() {
        js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.getMessage();
            return false;
        }
    }


}
