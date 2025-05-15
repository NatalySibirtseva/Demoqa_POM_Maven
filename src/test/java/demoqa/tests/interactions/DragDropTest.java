package demoqa.tests.interactions;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePanel;
import demoqa.pages.interactions.DroppablePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(app.driver, app.wait).getInteractions();
        new SidePanel(app.driver, app.wait).selectDroppable();
    }

    @Test
    public void actionDragMeTest(){
        new DroppablePage(app.driver, app.wait).actionDragMe().verifyDropped("Dropped!");
    }
}
