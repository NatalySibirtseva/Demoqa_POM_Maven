package demoqa.tests.alerts;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePanel;
import demoqa.pages.alertsFrameWindows.AlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getAlertsFrameWindows();
        new SidePanel(app.driver, app.wait).selectAlerts();
    }

    @Test
    public void alertWaitTest() {
        new AlertsPage(app.driver, app.wait).alertWithTime();
    }

    @Test
    public void AlertWithSelectTest(){
        new AlertsPage(app.driver, app.wait).selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertTest(){
        new AlertsPage(app.driver, app.wait).sendMessageToAlert("My message").verifyMessage("My message");
    }

}
