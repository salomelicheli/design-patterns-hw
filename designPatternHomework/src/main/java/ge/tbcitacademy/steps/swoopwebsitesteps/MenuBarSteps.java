package ge.tbcitacademy.steps.swoopwebsitesteps;

import ge.tbcitacademy.pages.swoop.MenuBarPages;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selectors.withText;

public class MenuBarSteps {
    MenuBarPages menu = new MenuBarPages();
    SoftAssert sfa = new SoftAssert();
    @Step("Accepting cookies")
    @Description("cookieButtonClick")
    public void cookieButtonClick(){
        menu.cookieButton.click();
    }
    @Step("Clicking on a following option on a menubar: {0}")
    @Description("This step clicks on each and every menubar available on the website")
    public MenuBarSteps menubars(String slct){
        menu.eachMenuBar.$(withText(slct)).click();
        return this;
    }
    @Step("Validate that 'four months' label is displayed on every page")
    @Description("This step validates if four months TBC label is available on all the pages")
    public void validatingFourMonthsLabel(){
       sfa.assertTrue((menu.fourMonthsLabel).isDisplayed());
    }
}
