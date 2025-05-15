package demoqa.tests.window;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePanel;
import demoqa.pages.alertsFrameWindows.BrowserWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindowTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getAlertsFrameWindows();
        new SidePanel(app.driver, app.wait).selectBrowserWindows().hideAds();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(app.driver, app.wait).switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }
}
