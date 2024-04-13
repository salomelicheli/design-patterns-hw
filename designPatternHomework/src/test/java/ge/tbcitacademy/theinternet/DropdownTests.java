package ge.tbcitacademy.theinternet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcitacademy.helper.ModifiedSelenide;
import ge.tbcitacademy.listeners.CustomListener;
import ge.tbcitacademy.steps.theinternetwebsitesteps.CheckboxAndDropdownSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.Link2;
import static ge.tbcitacademy.data.Constants.Link3;
@Epic("Selenide Homework")
@Feature("Dropdown Tests")
@Listeners(CustomListener.class)
public class DropdownTests {
    CheckboxAndDropdownSteps steps;
    @BeforeMethod
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new ModifiedSelenide());
        open(Link3);
        steps = new CheckboxAndDropdownSteps();
        Configuration.timeout = 7;
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @AfterMethod
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test selects an option from a dropdown and validates if it is correct")
    @Story("Dropdown modification test")
    public void dropDownTest() {
        steps.validatingDropdown()
                .selectingAnOption()
                .validatingAfterSelecting();
    }
}
