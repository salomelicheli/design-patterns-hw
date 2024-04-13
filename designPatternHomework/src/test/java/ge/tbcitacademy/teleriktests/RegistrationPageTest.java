package ge.tbcitacademy.teleriktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcitacademy.dataproviders.TelerikFormDataProvider;
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
@Feature("Forms Tests")
@Listeners(CustomListener.class)
public class RegistrationPageTest {
    FormPageSteps fillingForm;
    PricingPageSteps pricingSteps;
    DemosPageSteps demoSteps;
    @BeforeMethod
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
    @AfterMethod
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }
    @Test(dataProvider = "telerikFormData", dataProviderClass = TelerikFormDataProvider.class)
    @Description("This test validates order mechanics")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Prices test")
    public void validateOrderMechanics(String name, String lastName, String company, String number, String address
    ,String city, String code) {
        pricingSteps.goToPricingSection();
        demoSteps.acceptingCookies();
        pricingSteps.clickBuyingButtonOnComplete()
                .clickLoginDismissButton()
                .getAnnualPriceAndChangeTerm()
                .changingTerm()
                .validatePriceAfterTermChange()
                .clickOnDropDown()
                .chooseQuantityOption()
                .validatePriceAfterQuantityChange()
                .validateSubtotalValue()
                .hoverOnQuestionMark()
                .validateTotalDiscountsOnALabel()
                .validateSupportDiscountOnLabel()
                .validateTotalValue();
        fillingForm.ContinueAsGuest()
                .fillFirstNameField(name)
                .fillLastNameField(lastName)
                .fillCompanyField(company)
                .fillNumberField(number)
                .fillAddressField(address)
                .fillCityField(city)
                .fillCodeField(code)
                .fillCountryDropdown()
                .navigatingBackAndForward()
                .validateFieldsAfterRefresh(name, lastName, number, company, address, city, code);
    }
}
