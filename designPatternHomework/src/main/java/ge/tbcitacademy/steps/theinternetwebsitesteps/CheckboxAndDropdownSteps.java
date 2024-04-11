package ge.tbcitacademy.steps.theinternetwebsitesteps;

import ge.tbcitacademy.pages.theinternetwebsite.CheckboxesPage;
import ge.tbcitacademy.pages.theinternetwebsite.DropdownPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static ge.tbcitacademy.data.Constants.*;

public class CheckboxAndDropdownSteps {
    CheckboxesPage checkbox = new CheckboxesPage();
    DropdownPage dropdown = new DropdownPage();

    public CheckboxAndDropdownSteps setToSelected(){
        checkbox.checkBox.setSelected(true);
        return this;
    }
    public void validateCheckboxes(){
        checkbox.checkboxes.forEach(checkbox ->checkbox.shouldHave(attribute(typeConst, checkboxConst)));
    }

    public CheckboxAndDropdownSteps validatingDropdown(){
        dropdown.someDropdown.getSelectedOption().shouldHave(text(OPTION_TEXT));
        return this;
    }
    public CheckboxAndDropdownSteps selectingAnOption(){
        dropdown.someDropdown.selectOption(OPTION);
        return this;
    }
    public void validatingAfterSelecting(){
        dropdown.someDropdown.getSelectedOption().shouldHave(text(OPTION));
    }
}
