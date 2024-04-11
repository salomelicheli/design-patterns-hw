package ge.tbcitacademy.steps.telerikwebsitesteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import ge.tbcitacademy.pages.telerikwebsite.DemosPage;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.size;
import static ge.tbcitacademy.data.Constants.*;

public class DemosPageSteps {
    DemosPage demo = new DemosPage();

    public DemosPageSteps acceptingCookies(){
        demo.cookieButton.click();
        return this;
    }
    public DemosPageSteps goingToWebSection(){
        demo.webSection.click();
        return this;
    }
    public DemosPageSteps checkingIfWebTakesToCorrectSection(){
        Assert.assertTrue(demo.webLabel.isDisplayed());
        return this;
    }
    public DemosPageSteps validatingPurpleInEveryHoveringImg(){
        demo.hoveringImg.forEach(img -> img.hover().shouldHave(Condition.cssValue(backgroundColor, purple)));
        return this;
    }
    public DemosPageSteps validatingStickyElement() {
        demo.stickyElement.should(Condition.appear);
        return this;
    }
    public DemosPageSteps validatingKendoUICollection(){
        Assert.assertTrue(demo.collect.texts().contains(demos));
        return this;
    }
    public DemosPageSteps goingToDesktopSection(){
        demo.desktopSection.click();
        return this;
    }
    public DemosPageSteps validatingCollectionSize(){
        demo.filteredCollect.shouldHave(size(2));
        return this;
    }
    public DemosPageSteps validatingCorrectDesktopSection(){
        Assert.assertTrue(demo.desktopLabel.isDisplayed());
        return this;
    }
    public DemosPageSteps goingToMobileSection(){
        demo.mobileSection.click();
        return this;
    }
    public DemosPageSteps validatingMobileSection(){
        Assert.assertTrue(demo.mobileLabel.isDisplayed());
        return this;
    }
    public DemosPageSteps validatingXamarinCollection(){
        demo.xamarinElements.shouldHave(CollectionCondition.attributes("title"
                ,appStore
                ,googlePlay,
                frommicrosoft));
        return this;
    }
    public void validatingStickyPresence(){
        demo.stickyElement.shouldBe(Condition.visible);
    }
}
