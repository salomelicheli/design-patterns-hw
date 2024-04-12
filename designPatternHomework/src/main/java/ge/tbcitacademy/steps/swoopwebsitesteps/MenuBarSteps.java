package ge.tbcitacademy.steps.swoopwebsitesteps;

import ge.tbcitacademy.pages.swoop.MenuBarPages;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selectors.withText;

public class MenuBarSteps {
    MenuBarPages menu = new MenuBarPages();
    SoftAssert sfa = new SoftAssert();
    public void cookieButtonClick(){
        menu.cookieButton.click();
    }
    public MenuBarSteps menubars(String slct){
        menu.eachMenuBar.$(withText(slct)).click();
        return this;
    }
    public void validatingFourMonthsLabel(){
       sfa.assertTrue((menu.fourMonthsLabel).isDisplayed());
    }
}
