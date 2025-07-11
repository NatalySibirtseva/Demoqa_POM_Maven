package demoqa.pages.widgets;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
//        Select select = new Select(oldSelectMenu);
//        select.selectByVisibleText(color);
        //ili napischem eto zhe po drugomy/prosche
        new Select(oldSelectMenu).selectByVisibleText(color);
        return this;
    }

    public SelectMenuPage verifyColor() {
//        new Select (oldSelectMenu).getFirstSelectedOption();
//        Assert.assertTrue(new Select(oldSelectMenu)
//                .getFirstSelectedOption()
//                .getText().contains(color));
        String firstSelectedOption = new Select(oldSelectMenu).getFirstSelectedOption()
                .getText();
        Assert.assertTrue(shouldHaveText(oldSelectMenu, firstSelectedOption, 5));
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    @FindBy(css = "html")
    WebElement space;

    public SelectMenuPage multiSelect(String[] colors) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != null) {
                inputSelect.sendKeys(colors[i]);
                inputSelect.sendKeys(Keys.ENTER);
            }
        }
        click(space);
        return this;
    }

    @FindBy(id = "cars")
    WebElement selectCars;

    public SelectMenuPage standardMultiSelect(String[] cars) {
        Select multi = new Select(selectCars);
        for (int i = 0; i < cars.length; i++) {
            if (multi.isMultiple()) {
                multi.selectByVisibleText(cars[i]);
            }
        }
        List<WebElement> options = multi.getAllSelectedOptions();
        for (WebElement el : options) {
            System.out.println(el.getText() + "//-> multi");
        }
        return this;
    }
}
