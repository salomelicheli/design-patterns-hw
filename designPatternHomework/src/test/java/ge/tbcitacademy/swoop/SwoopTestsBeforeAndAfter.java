package ge.tbcitacademy.swoop;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.steps.swoopwebsitesteps.BurgerSearchSteps;
import ge.tbcitacademy.steps.swoopwebsitesteps.MenuBarSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.swoopSite;

public class SwoopTestsBeforeAndAfter {
    SoftAssert sfa = new SoftAssert();
    BurgerSearchSteps search;
    MenuBarSteps steps;
    @BeforeTest
    public void beforeClass() {
        open(swoopSite);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        search = new BurgerSearchSteps();
        steps = new MenuBarSteps();
        steps.cookieButtonClick();
    }
    @AfterTest
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
        sfa.assertAll();
    }
}
