package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public ProfilePage verifyUserName(String text) {
        //assert userNameValue.getText().contains(text) : "Username does not contains the expected text.";
        //javavskii assert vstroenniy, ne osobo udobniy
        String expectedText = text;
        String actualText = userNameValue.getText();
        String errorMessage = "\nExpected text: " + expectedText + ",\nActual text: " + actualText;
        Assert.assertTrue(actualText.contains(expectedText), errorMessage);
        return this;
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public ProfilePage typeKeyInSearchInput(String text) {
        type(searchBox, text);
        return this;
    }

    @FindBy(css = ".mr-2 a")
    WebElement nameOfBook;

    public ProfilePage verifyNameOfBook(String text) {
        Assert.assertTrue(shouldHaveText(nameOfBook, text, 5));
        return this;
    }


}
