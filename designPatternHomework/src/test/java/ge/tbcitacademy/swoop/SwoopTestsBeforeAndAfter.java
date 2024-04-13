package ge.tbcitacademy.swoop;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcitacademy.helper.ModifiedSelenide;
import ge.tbcitacademy.listeners.CustomListener;
import ge.tbcitacademy.steps.swoopwebsitesteps.BurgerSearchSteps;
import ge.tbcitacademy.steps.swoopwebsitesteps.MenuBarSteps;
import io.qameta.allure.Epic;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.swoopSite;
@Epic("Swoop Tests")
@Listeners(CustomListener.class)
public class SwoopTestsBeforeAndAfter {
    SoftAssert sfa = new SoftAssert();
    BurgerSearchSteps search;
    MenuBarSteps steps;
    @BeforeTest
    public void beforeClass() {
        SelenideLogger.addListener("AllureSelenide", new ModifiedSelenide());
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
