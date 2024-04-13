package ge.tbcitacademy.teleriktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcitacademy.helper.ModifiedSelenide;
import ge.tbcitacademy.listeners.CustomListener;
import ge.tbcitacademy.steps.telerikwebsitesteps.DemosPageSteps;
import ge.tbcitacademy.steps.telerikwebsitesteps.FormPageSteps;
import ge.tbcitacademy.steps.telerikwebsitesteps.PricingPageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.TELERIK;

@Epic("Selenide Homework")
@Feature("Pricing tests")
@Listeners(CustomListener.class)
public class PricingPageTests {
    FormPageSteps fillingForm;
    PricingPageSteps pricingSteps;
    DemosPageSteps demoSteps;
    @BeforeTest
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new ModifiedSelenide());
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
    @Test
    @Description("This test validates bundle offers on pricing page")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Test to validate bundle offers")
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
    @Test
    @Description("This test validates individual offers on pricing page")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test to validate individual offers, prices")
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
    @Test
    @Description("This test validates demos design on pricing page")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Test to validate demo design")
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
