package ge.tbcitacademy.pages.theinternetwebsite;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbcitacademy.data.Constants.checkboxConst;
import static ge.tbcitacademy.data.Constants.typeConst;

public class CheckboxesPage {
    public SelenideElement checkBox = $(byAttribute(typeConst, checkboxConst));
    public ElementsCollection checkboxes = $$("input[type='checkbox']");
}
