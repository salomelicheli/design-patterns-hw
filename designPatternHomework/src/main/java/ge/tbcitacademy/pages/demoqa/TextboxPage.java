package ge.tbcitacademy.pages.demoqa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.emailConst;
import static ge.tbcitacademy.data.Constants.typeConst;

public class TextboxPage {
    public SelenideElement userInput = $("#userName");
    public SelenideElement emailField =  $(by(typeConst, emailConst));
    public SelenideElement currentAddressField =  $("#currentAddress");
    public SelenideElement permaddressField = $("#permanentAddress");
    public SelenideElement submitButton =  $("#submit");
    public ElementsCollection outputField = $$("#output p");
}
