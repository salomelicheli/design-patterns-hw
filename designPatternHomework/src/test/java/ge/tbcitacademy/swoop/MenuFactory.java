package ge.tbcitacademy.swoop;

import ge.tbcitacademy.steps.swoopwebsitesteps.MenuBarSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MenuFactory extends SwoopTestsBeforeAndAfter{
    MenuBarSteps steps = new MenuBarSteps();
    private String menuName;
    public MenuFactory(String menuName) {
        this.menuName = menuName;
    }
    SoftAssert sfa = new SoftAssert();
    @Test
    @Description("This test checks whether if the 4 months bar is displayed on all the pages")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Test to check the label")
    public void testName() {
        steps.menubars(menuName)
             .validatingFourMonthsLabel();
    }
}
