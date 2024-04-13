package ge.tbcitacademy.steps.theinternetwebsitesteps;

import ge.tbcitacademy.pages.theinternetwebsite.CheckboxesPage;
import ge.tbcitacademy.pages.theinternetwebsite.DropdownPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static ge.tbcitacademy.data.Constants.*;

public class CheckboxAndDropdownSteps {
    CheckboxesPage checkbox = new CheckboxesPage();
    DropdownPage dropdown = new DropdownPage();
    @Step("choosing a checkbox option")
    @Description("This step chooses a checkbox option")
    public CheckboxAndDropdownSteps setToSelected(){
        checkbox.checkBox.setSelected(true);
        return this;
    }
    @Step("Validating checkboxes...")
    @Description("This step validates that both checkboxes have checkbox as their type attribute")
    public void validateCheckboxes(){
        checkbox.checkboxes.forEach(checkbox ->checkbox.shouldHave(attribute(typeConst, checkboxConst)));
    }
    @Step("Validating the dropdown selected option")
    @Description("This step validates that dropdown option is set to - Please, select an option")
    public CheckboxAndDropdownSteps validatingDropdown(){
        dropdown.someDropdown.getSelectedOption().shouldHave(text(OPTION_TEXT));
        return this;
    }
    @Step("Selecting an other option from a dropdown")
    @Description("This step selects the other option from the dropdown")
    public CheckboxAndDropdownSteps selectingAnOption(){
        dropdown.someDropdown.selectOption(OPTION);
        return this;
    }
    @Step("Validating an option...")
    @Description("This step validates the dropdown option again after re-selecting it")
    public void validatingAfterSelecting(){
        dropdown.someDropdown.getSelectedOption().shouldHave(text(OPTION));
    }
}
