package demoqa.pages.forms;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "lastName")
    WebElement lastNameField;
    @FindBy(id = "userEmail")
    WebElement userEmailField;
    @FindBy(id = "userNumber")
    WebElement userNumberField;

    public PracticeFormPage enterPersonalDates(String name, String lastname, String email, String phone) {
        type(firstNameField, name, 100);
        type(lastNameField, lastname, 100);
        type(userEmailField, email, 100);
        type(userNumberField, phone, 100);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement maleRadio;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement femaleRadio;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement otherRadio;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(maleRadio);
        } else if (gender.equals("Female")) {
            click(femaleRadio);
        } else if (gender.equals("Other")) {
            click(otherRadio);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage enterDateOfBirth(String date) {
        click(dateOfBirthInput);
        String osName = System.getProperty("os.name");
        System.out.println("My OS: " + osName);
        if (osName.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for = 'hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(css = "[for = 'hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for = 'hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobbies(String[] hobbys) {
        for (int i = 0; i < hobbys.length; i++) {
            if (hobbys[i].equals("Sports")) {
                click(sports);
            }
            if (hobbys[i].equals("Reading")) {
                click(reading);
            }
            if (hobbys[i].equals("Music")) {
                click(music);
            }

        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path) {
        // String path1 = new File(path).getAbsolutePath();
        // System.out.println(path1);
        // uploadPicture.sendKeys(path1);
        uploadPicture.sendKeys(path);
        return this;
    }
}
