package ge.tbcitacademy.swoop;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.steps.swoopwebsitesteps.MenuBarSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;
import static ge.tbcitacademy.data.Constants.swoopSite;

public class MenuFactory extends SwoopTestsBeforeAndAfter{
    MenuBarSteps steps = new MenuBarSteps();
    private String menuName;
    public MenuFactory(String menuName) {
        this.menuName = menuName;
    }
    SoftAssert sfa = new SoftAssert();
    @Test
    public void testName() {
        steps.menubars(menuName)
             .validatingFourMonthsLabel();
    }
}
