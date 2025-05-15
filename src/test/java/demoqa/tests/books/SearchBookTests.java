package demoqa.tests.books;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(app.driver, app.wait).getBookStore();
    }

    @Test
    public void searchBookPositiveTest(){
        new ProfilePage(app.driver, app.wait)
                .typeKeyInSearchInput("git")
                .verifyNameOfBook("Git");
    }
}
