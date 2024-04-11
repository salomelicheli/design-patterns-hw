package ge.tbcitacademy.pages.swoop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MenuBarPages {
    public SelenideElement eachMenuBar = $x("//div[@class='Menus']");
    public SelenideElement cookieButton = $(".cookieButton");
    public SelenideElement fourMonthsLabel = $(byText("გაანაწილე 4 თვეზე"));
}
