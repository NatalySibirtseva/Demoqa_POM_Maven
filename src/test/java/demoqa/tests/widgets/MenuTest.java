package demoqa.tests.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePanel;
import demoqa.pages.widgets.MenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(app.driver, app.wait).getWidgets();
        new SidePanel(app.driver, app.wait).getMenu().hideAds();
    }

    @Test
    public void moveToMenuTest(){
        new MenuPage(app.driver, app.wait).selectSubMenu().verifySubMenu();
    }
}
