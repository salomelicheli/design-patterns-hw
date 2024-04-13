package ge.tbcitacademy.steps.telerikwebsitesteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import ge.tbcitacademy.pages.telerikwebsite.DemosPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.size;
import static ge.tbcitacademy.data.Constants.*;

public class DemosPageSteps {
    DemosPage demo = new DemosPage();

    @Step("Accepting cookies")
    @Description("This step acceps the cookies as the website starts")
    public DemosPageSteps acceptingCookies(){
        demo.cookieButton.click();
        return this;
    }
    @Step("Going to the web section")
    @Description("This step navigates to the web section")
    public DemosPageSteps goingToWebSection(){
        demo.webSection.click();
        return this;
    }
    @Step("Checking if a web button takes to the correct section")
    @Description("This step checks if we've been taken to the web section correctly")
    public DemosPageSteps checkingIfWebTakesToCorrectSection(){
        Assert.assertTrue(demo.webLabel.isDisplayed());
        return this;
    }
    @Step("Validating that on every single element purple pic is displayed while hovering")
    @Description("This step validates if purple image appears on every single element when hovering a mouse over")
    public DemosPageSteps validatingPurpleInEveryHoveringImg(){
        demo.hoveringImg.forEach(img -> img.hover().shouldHave(Condition.cssValue(backgroundColor, purple)));
        return this;
    }
    @Step("Validating that the sticky element appears...")
    @Description("This step validates if the bar remains sticky through the test")
    public DemosPageSteps validatingStickyElement() {
        demo.stickyElement.should(Condition.appear);
        return this;
    }
    @Step("Validating kendo UI collection")
    @Description("This step validates if a Kendo UI collection contains certain elements")
    public DemosPageSteps validatingKendoUICollection(){
        Assert.assertTrue(demo.collect.texts().contains(demos));
        return this;
    }
    @Step("Going to desktop section")
    @Description("This step takes us to the desktop section")
    public DemosPageSteps goingToDesktopSection(){
        demo.desktopSection.click();
        return this;
    }
    @Step("Validating if the collection size is as expected")
    @Description("This step checks if the size of the collection is as expected")
    public DemosPageSteps validatingCollectionSize(){
        demo.filteredCollect.shouldHave(size(2));
        return this;
    }
    @Step("Checking if a desktop button takes to the correct section")
    @Description("This step checks if we've been taken to the desktop section correctly")
    public DemosPageSteps validatingCorrectDesktopSection(){
        Assert.assertTrue(demo.desktopLabel.isDisplayed());
        return this;
    }
    @Step("Going to mobile section")
    @Description("This step takes us to the mobile section of the page")
    public DemosPageSteps goingToMobileSection(){
        demo.mobileSection.click();
        return this;
    }
    @Step("Checking if a mobile button takes to the correct section")
    @Description("This step validates if we've ended up on the mobile section correctly")
    public DemosPageSteps validatingMobileSection(){
        Assert.assertTrue(demo.mobileLabel.isDisplayed());
        return this;
    }
    @Step("Validating Xamarin collections")
    @Description("This step validates if Xamarin collection contains certain bundle elements")
    public DemosPageSteps validatingXamarinCollection(){
        demo.xamarinElements.shouldHave(CollectionCondition.attributes("title"
                ,appStore
                ,googlePlay,
                frommicrosoft));
        return this;
    }
    @Step("Validating that the sticky element is present after scrolling")
    @Description("This step checks if the tab remained sticky till the end of the process")
    public void validatingStickyPresence(){
        demo.stickyElement.shouldBe(Condition.visible);
    }
}
