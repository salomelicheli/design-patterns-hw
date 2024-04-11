package ge.tbcitacademy.teleriktests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.dataproviders.TelerikFormDataProvider;
import ge.tbcitacademy.steps.telerikwebsitesteps.DemosPageSteps;
import ge.tbcitacademy.steps.telerikwebsitesteps.FormPageSteps;
import ge.tbcitacademy.steps.telerikwebsitesteps.PricingPageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.TELERIK;

public class RegistrationPageTest {
    FormPageSteps fillingForm;
    PricingPageSteps pricingSteps;
    DemosPageSteps demoSteps;
    @BeforeMethod
    public void setUp(){
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
