package ge.tbcitacademy.steps.telerikwebsitesteps;

import ge.tbcitacademy.pages.telerikwebsite.FormPage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.forward;
import static ge.tbcitacademy.data.Constants.*;

public class FormPageSteps {
    FormPage filling = new FormPage();

    public FormPageSteps ContinueAsGuest(){
        filling.continueAsGuestButton.scrollTo().click();
        return this;
    }
    public FormPageSteps fillFirstNameField(String someName){
        filling.firstNameField.sendKeys(someName);
        return this;
    }
    public FormPageSteps fillLastNameField(String someLastName){
        filling.lastNameField.sendKeys(someLastName);
        return this;
    }
    public FormPageSteps fillCompanyField(String someCompany){
        filling.companyField.sendKeys(someCompany);
        return this;
    }
    public FormPageSteps fillNumberField(String someNumber){
        filling.numberField.sendKeys(someNumber);
        return this;
    }
    public FormPageSteps fillAddressField(String someAddress){
        filling.addressField.sendKeys(someAddress);
        return this;
    }
    public FormPageSteps fillCityField(String someCity){
        filling.cityField.sendKeys(someCity);
        return this;
    }
    public FormPageSteps fillCodeField(String postalCode){
        filling.zipCodeField.sendKeys(postalCode);
        return this;
    }
    public FormPageSteps fillCountryDropdown(){
        filling.elm.sendKeys("Ge");
        filling.elm.pressEnter();
        return this;
    }
    public FormPageSteps navigatingBackAndForward(){
        back();
        forward();
        return this;
    }
    public void validateFieldsAfterRefresh(String someName, String someLastName,String someNumber
            , String someCompany, String someAddress, String someCity, String postalCode){
        filling.allFields.shouldHave(texts(someName,someLastName,someCompany,someNumber,someAddress,
                someCity,postalCode));
    }
}
