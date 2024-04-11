package ge.tbcitacademy.helper;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.clickable;

public class HelperMethods {
    public static void checkingBox(SelenideElement checkBoxElement){
        checkBoxElement.shouldNotBe(checked);
        checkBoxElement.setSelected(true);
        checkBoxElement.shouldBe(checked);
    }
    public static void uncheckingBox(SelenideElement checkbox){
        checkbox.shouldBe(checked);
        checkbox.setSelected(false);
        checkbox.shouldNotBe(checked);
    }
    public static void selectOption(SelenideElement radioButton){
        radioButton.shouldBe(clickable);
        radioButton.setSelected(true);
    }
    public static double extractPrice(SelenideElement el, int rand){
        String percentText = el.getText();
        return Double.parseDouble((percentText).substring(rand));
    }
    public static double modifyAndExtractPrice(SelenideElement el, int rand){
        String percentText = el.getText();
        return Double.parseDouble((percentText).substring(rand).replaceAll("[,\\s]+", ""));
    }
    public static double extractPrice(SelenideElement el){
        String priceText = el.getText();
        return Double.parseDouble((priceText).substring(0, priceText.length() - 1));
    }
    public static double extractPercent(SelenideElement el){
        String percentText = el.getText();
        return Double.parseDouble((percentText).substring(1, percentText.length()-1));
    }
}
