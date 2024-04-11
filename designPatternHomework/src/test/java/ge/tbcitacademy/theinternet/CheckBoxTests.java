package ge.tbcitacademy.theinternet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.steps.theinternetwebsitesteps.CheckboxAndDropdownSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.Link2;

public class CheckBoxTests {
    CheckboxAndDropdownSteps steps;
    @BeforeClass
    public void setUp(){
        open(Link2);
        steps = new CheckboxAndDropdownSteps();
        Configuration.timeout = 7;
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @AfterClass
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }
    @Test
    public void checkBoxTest() {
        steps.setToSelected()
                .validateCheckboxes();
    }
}
