package demoqa.tests.books;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        // new HomePage(app.driver, app.wait).getBookStore(); //click po ssilke na homepage BookStore
        //  new SidePanel(app.driver, app.wait).selectLogin(); //click na login sboky na panelle
        //tut mozno sokratit
        new HomePage(app.driver, app.wait)
                .getBookStore()
                .selectLogin()
                .hideAds();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData("PORTISHEAD", "Password@1")
                .clickOnLoginButton()
                .verifyUserName("PORTISHEAD");
    }
}
