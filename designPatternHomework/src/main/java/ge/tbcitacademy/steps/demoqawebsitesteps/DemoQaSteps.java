package ge.tbcitacademy.steps.demoqawebsitesteps;

import ge.tbcitacademy.pages.demoqa.TextboxPage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static ge.tbcitacademy.data.Constants.*;

public class DemoQaSteps {
    TextboxPage txtbox = new TextboxPage();

    public DemoQaSteps scrollToInput(){
        txtbox.userInput.scrollTo();
        return this;
    }
    public DemoQaSteps typingUsernameToField(String name){
        txtbox.userInput.sendKeys(name);
        return this;
    }
    public DemoQaSteps typingEmail(String email){
        txtbox.emailField.sendKeys(email);
        return this;
    }
    public DemoQaSteps typingCurrentAddress(String currentAddress){
        txtbox.currentAddressField.sendKeys(currentAddress);
        return this;
    }
    public DemoQaSteps typingPermanentAddress(String permAddress){
        txtbox.permaddressField.sendKeys(permAddress);
        return this;
    }
    public DemoQaSteps scrollingToSubmitButton(){
        txtbox.permaddressField.scrollTo();
        return this;
    }
    public DemoQaSteps clickOnSumbitButton() {
        txtbox.submitButton.click();
        return this;
    }
    public void validatingOutputField(String name, String email, String currentAddress, String permAddress){
        txtbox.outputField.shouldHave(texts(name,email,currentAddress,permAddress));
    }
}
