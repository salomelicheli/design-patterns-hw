package ge.tbcitacademy.steps.telerikwebsitesteps;

import ge.tbcitacademy.pages.telerikwebsite.FormPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.forward;
import static ge.tbcitacademy.data.Constants.*;

public class FormPageSteps {
    FormPage filling = new FormPage();

    @Step("Continuing to fill the form as a guest...")
    @Description("This step clicks on a continue as guest button that takes us to the form page")
    public FormPageSteps ContinueAsGuest(){
        filling.continueAsGuestButton.scrollTo().click();
        return this;
    }
    @Step("Filling out first name field with a following value: {0}")
    @Description("This step fills in the first name in a field")
    public FormPageSteps fillFirstNameField(String someName){
        filling.firstNameField.sendKeys(someName);
        return this;
    }
    @Step("Filling out last name field with a following value: {0}")
    @Description("This step fills in the last name in a field")
    public FormPageSteps fillLastNameField(String someLastName){
        filling.lastNameField.sendKeys(someLastName);
        return this;
    }
    @Step("Filling out company name field with a following value: {0}")
    @Description("This step fills in the company name in a field")
    public FormPageSteps fillCompanyField(String someCompany){
        filling.companyField.sendKeys(someCompany);
        return this;
    }
    @Step("Filling out phone number field with a following value: {0}")
    @Description("This step fills in the phone number in a field")
    public FormPageSteps fillNumberField(String someNumber){
        filling.numberField.sendKeys(someNumber);
        return this;
    }
    @Step("Filling out address field with a following value: {0}")
    @Description("This step fills in the address in a field")
    public FormPageSteps fillAddressField(String someAddress){
        filling.addressField.sendKeys(someAddress);
        return this;
    }
    @Step("Filling out City field with a following value: {0}")
    @Description("This step puts the city where user lives in a field")
    public FormPageSteps fillCityField(String someCity){
        filling.cityField.sendKeys(someCity);
        return this;
    }
    @Step("Filling out postal code field with a following value: {0}")
    @Description("This step fills in the postal code in a field")
    public FormPageSteps fillCodeField(String postalCode){
        filling.zipCodeField.sendKeys(postalCode);
        return this;
    }
    @Step("Filling out country dropdown field with a following value")
    @Description("This step fills in the country in a dropdown")
    public FormPageSteps fillCountryDropdown(){
        filling.elm.sendKeys("Ge");
        filling.elm.pressEnter();
        return this;
    }
    @Step("Navigating back and forward")
    @Description("This step navigates back and forward to see if the data remains still in the fields")
    public FormPageSteps navigatingBackAndForward(){
        back();
        forward();
        return this;
    }
    @Step("validating after navigation that the following values are still present: {0}, {1}, {2}, {3}, {5}, {6}, {7}")
    @Description("This step validates dara in the field after moving back and forward")
    public void validateFieldsAfterRefresh(String someName, String someLastName,String someNumber
            , String someCompany, String someAddress, String someCity, String postalCode){
        filling.allFields.shouldHave(texts(someName,someLastName,someCompany,someNumber,someAddress,
                someCity,postalCode));
    }
}
