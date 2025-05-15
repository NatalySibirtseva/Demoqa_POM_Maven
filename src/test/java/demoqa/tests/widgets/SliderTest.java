package demoqa.tests.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePanel;
import demoqa.pages.widgets.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getWidgets();
        new SidePanel(app.driver, app.wait).selectSlider().hideAds();
    }

    @Test
    public void sliderTest(){
        new SliderPage(app.driver, app.wait).moveSliderInHorizontalDirection().verifySliderValue("100");
    }
}
