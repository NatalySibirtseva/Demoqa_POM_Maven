package demoqa.tests.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePanel;
import demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getForms();
        new SidePanel(app.driver, app.wait).selectPracticeForm().hideAds();
    }

    @Test
    public void createStudentAccount() {
        new PracticeFormPage(app.driver, app.wait).enterPersonalDates("Robert", "Smith", "kris1@gm.com", "0123456789")
               .selectGender("Female")
               .enterDateOfBirth("10 May 1990")
                .addSubject(new String[]{"English", "Maths"})
               .selectHobbies(new String[]{"Music", "Sports"})
               //.uploadFile("src/images/boxer-3627742_640.jpg")
               .uploadFile("C:/QAProjects/DemoQA_POM_Maven/src/images/boxer-3627742_640.jpg")
//                .inputState("NCR")
//                .inputCity("Delhi")
//                .submit()
//                .verifySuccessRegistration("")
                ;

    }


}
