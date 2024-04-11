package ge.tbcitacademy.pages.demoqa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormPage {
   public SelenideElement nameInput = $("#firstName");
   public SelenideElement lastNameInput = $("#lastName");
   public SelenideElement submitButton =  $("#submit");
   public SelenideElement phoneNumberField = $("#userNumber");
   public SelenideElement name = $(byText("Student Name")).sibling(0);

}
