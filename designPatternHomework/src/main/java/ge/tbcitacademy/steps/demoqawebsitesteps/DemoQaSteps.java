package ge.tbcitacademy.steps.demoqawebsitesteps;

import ge.tbcitacademy.pages.demoqa.TextboxPage;
import io.qameta.allure.Description;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.checkerframework.common.value.qual.StaticallyExecutable;

import static com.codeborne.selenide.CollectionCondition.texts;
import static ge.tbcitacademy.data.Constants.*;

public class DemoQaSteps {
    TextboxPage txtbox = new TextboxPage();

    @Step("Scrolling to a textbox so it's into view")
    @Description("this step scrolls to an input box")
    public DemoQaSteps scrollToInput(){
        txtbox.userInput.scrollTo();
        return this;
    }
    @Step("Typing a following username in the corresponding field: {0}")
    @Description("this step types username to the field")
    public DemoQaSteps typingUsernameToField(String name){
        txtbox.userInput.sendKeys(name);
        return this;
    }
    @Step("Typing following email in a corresponding field: {0}")
    @Description("this step types user email to the field")
    public DemoQaSteps typingEmail(String email){
        txtbox.emailField.sendKeys(email);
        return this;
    }
    @Step("Typing current address in a corresponding field: {0}")
    @Description("this step types user current address to the field")
    public DemoQaSteps typingCurrentAddress(String currentAddress){
        txtbox.currentAddressField.sendKeys(currentAddress);
        return this;
    }
    @Step("Typing permanent address in a corresponding field: {0}")
    @Description("this step types user's permanent address to the field")
    public DemoQaSteps typingPermanentAddress(String permAddress){
        txtbox.permaddressField.sendKeys(permAddress);
        return this;
    }
    @Step("scrolling so the submit button is into view for clicking")
    @Description("this step scrolls to the submit button")
    public DemoQaSteps scrollingToSubmitButton(){
        txtbox.permaddressField.scrollTo();
        return this;
    }
    @Step("Clicking on a submit button to see the result")
    @Description("this step clicks on the submit button")
    public DemoQaSteps clickOnSumbitButton() {
        txtbox.submitButton.click();
        return this;
    }
    @Step("validating if values are correctly displayed in an output field: {0}, {1}, {2}, {3}")
    @Description("This step validates all the values written in the fields")
    public void validatingOutputField(String name, String email, String currentAddress, String permAddress){
        txtbox.outputField.shouldHave(texts(name,email,currentAddress,permAddress));
    }
}
