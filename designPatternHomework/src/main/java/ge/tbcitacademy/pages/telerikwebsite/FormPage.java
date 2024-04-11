package ge.tbcitacademy.pages.telerikwebsite;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormPage {
   public SelenideElement continueAsGuestButton = $(byText("Continue as Guest"));
   public SelenideElement firstNameField =  $("#biFirstName");
   public SelenideElement lastNameField = $("#biLastName");
   public SelenideElement companyField = $("#biCompany");
   public SelenideElement numberField = $("#biPhone");
   public SelenideElement addressField = $("#biAddress");
   public SelenideElement cityField =  $("#biCity");
   public SelenideElement zipCodeField = $("#biZipCode");
   public SelenideElement elm = $(".k-input");
   public ElementsCollection allFields =  $$("input[type='text']");

}
