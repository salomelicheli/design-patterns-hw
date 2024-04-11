package ge.tbcitacademy.teleriktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.steps.telerikwebsitesteps.DemosPageSteps;
import ge.tbcitacademy.steps.telerikwebsitesteps.FormPageSteps;
import ge.tbcitacademy.steps.telerikwebsitesteps.PricingPageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.TELERIK;

public class PricingPageTests {
    FormPageSteps fillingForm;
    PricingPageSteps pricingSteps;
    DemosPageSteps demoSteps;
    @BeforeTest
    public void setUp(){
        open(TELERIK);
        pricingSteps = new PricingPageSteps();
        demoSteps =  new DemosPageSteps();
        fillingForm =  new FormPageSteps();
        Configuration.timeout = 9000;
        WebDriverManager.chromedriver().setup();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @AfterTest
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }
    @Test()
    public void validateVundleOffers() {
        pricingSteps.goToPricingSection()
                .scrollToPricingButton()
                .clickingButtonToSeeMore()
                .validatingEscalationInUltimatePackage()
                .validatingTestStudio()
                .validateTelerikReportingInUltimateAndComplete()
                .onDemandVideosInAllOffers()
                .validateInstaceText()
                .mockingSolutionInDevUI()
                .endToEndInUltimate();
    }
    @Test()
    public void validateIndividualOffers(){
        pricingSteps.goToPricingSection()
                .clickOnIndividualProducts()
                .hoverOnAHeader()
                .validateApparitionOfANinja()
                .scrollToPrice()
                .validatingDropdowns()
                .validateKendoUIPrice()
                .validateKendoReactPricing();
    }
    @Test()
    public void validateDemosDesign() {
        demoSteps.acceptingCookies()
                .goingToWebSection()
                .checkingIfWebTakesToCorrectSection()
                .validatingPurpleInEveryHoveringImg()
                .validatingStickyElement()
                .validatingKendoUICollection()
                .goingToDesktopSection()
                .validatingCollectionSize()
                .validatingCorrectDesktopSection()
                .goingToMobileSection()
                .validatingMobileSection()
                .validatingXamarinCollection()
                .validatingStickyPresence();
    }
}
